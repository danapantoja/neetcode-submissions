class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int max = 0;
        for (int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                dp[i][j] = dfs(dp,i,j,matrix,-1,directions);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    public int dfs(int[][] dp, int row, int col, int[][]matrix, int prev, int[][]directions){
        if (row<0||col<0||row>=matrix.length||col>=matrix[0].length|| prev >=matrix[row][col]){
            return 0;
        }
        if(dp[row][col]!=0){
            return dp[row][col];
        }
        int max = 1;
        for (int[] dir : directions){
            max = Math.max(max, 1+ dfs(dp, row + dir[0], col+dir[1], matrix, matrix[row][col], directions));
        }
        dp[row][col] = max;
        return max;

    }
}
