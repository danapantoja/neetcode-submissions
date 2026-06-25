class Solution:
    def solve(self, board: List[List[str]]) -> None:
        
        directions =[[0,1],[0,-1],[-1,0],[1,0]]
        def dfs(i,j, board, letter1, letter2):
            if i < 0 or j < 0 or i >=len(board) or j >=len(board[0]) or board[i][j]!=letter1:
                return
            board[i][j]=letter2
            for row, col in directions:
                new_row = i + row
                new_col = j + col
                dfs(new_row,new_col,board, letter1, letter2)
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if i==0 or j ==0 or i ==len(board)-1 or j==len(board[0])-1:
                    dfs(i,j,board,'O','B')
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                dfs(i,j,board,'O','X')
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                dfs(i,j,board,'B','O')
        