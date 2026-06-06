class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        ans=[]
        board = [['.'] * n for _ in range(n)]

        self.solve(board,ans,0)
        return ans

    def valid(self,board,row,col):
        #Check Col
        for r in range(row-1,-1,-1):
            if board[r][col]=='Q':
                return False

        #Check Diag
        i,j=row-1,col+1
        while(i>=0 and j<len(board)):
            if board[i][j]=='Q':
                return False
            i-=1
            j+=1

        #Check Anti-Diag
        i,j=row-1,col-1
        while(i>=0 and j>=0):
            if board[i][j]=='Q':
                return False
            i-=1
            j-=1
        return True

    def solve(self,board,ans,row):
        if row>=len(board):
            smallAns=[]
            for r in board:
                smallAns.append(''.join(r))
            ans.append(smallAns)
            return

        for col in range(len(board)):
            if self.valid(board,row,col):
                board[row][col] = 'Q'
                self.solve(board,ans,row+1)
                board[row][col]='.'