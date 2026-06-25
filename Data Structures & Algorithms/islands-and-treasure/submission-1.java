class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        for (int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    visited.add(i+","+j);
                    queue.offer(new int[]{i,j,0});
                }
            }
        }
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!queue.isEmpty()){
            int n = queue.size();
            for (int i =0;i<n;i++){
                int[]cell =queue.poll();
                int r = cell[0];
                int c=cell[1];
                int dist = cell[2];
                for (int[] dir : directions){
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    if(newR < 0 || newC< 0 || newC >=grid[0].length || newR >= grid.length || grid[newR][newC]==-1 || visited.contains(newR+","+newC)){
                        continue;
                    }
                    visited.add(newR+","+newC);
                    if (grid[newR][newC]==Integer.MAX_VALUE){
                        grid[newR][newC] = Math.min(grid[newR][newC],dist + 1);
                    }
                    queue.offer(new int []{newR, newC, dist + 1});
                }
            }
            
        }
        
    }
}
