class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check rows
        for (int row =0;row<9;row++){
            Set<Character> map =new HashSet<>();
            for (int i=0;i<9;i++){
                if (board[row][i]=='.') continue;
                if (map.contains(board[row][i])) return false;
                map.add(board[row][i]);
            }
        }
        //check col
        for (int col =0;col< 9;col++){
            Set<Character> map = new HashSet<>();
            for (int i =0; i<9;i++){
                if (board[i][col]=='.') continue;

                if(map.contains(board[i][col])) return false;
                map.add(board[i][col]);
            }
        }
        //check squares
        for (int square =0; square < 9;square++){
            //for each square, we make a new set to see if there are any duplicates
             Set<Character> map = new HashSet<>();
            for (int i =0;i<3;i++){
                for (int j =0;j<3;j++){
                    //getting the indexes of the specific square we are in
                    int row = (square/3)*3 +i;
                    int col = (square%3) *3 +j;
                    if (board[row][col]=='.') continue;
                    if (map.contains(board[row][col])) return false;
                    map.add(board[row][col]);
                }

            }

        }
        return true;


    }

    
}
