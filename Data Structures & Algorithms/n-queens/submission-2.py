class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        ans=[]
        board = [['.'] * n for _ in range(n)]

        col_set, diag_set, anti_diag_set = set(), set(), set()
        self.solve(board,ans,0,col_set,diag_set,anti_diag_set)
        return ans

    def solve(self,board,ans,row,col_set,diag_set,anti_diag_set):
        if row>=len(board):
            smallAns=[]
            for r in board:
                smallAns.append(''.join(r))
            ans.append(smallAns)
            return

        for col in range(len(board)):
            diag_num = row-col
            anti_diag_num = row+col
            if col in col_set or diag_num in diag_set or anti_diag_num in anti_diag_set:
                continue

            board[row][col] = 'Q'
            col_set.add(col)
            diag_set.add(diag_num)
            anti_diag_set.add(anti_diag_num)

            self.solve(board,ans,row+1,col_set,diag_set,anti_diag_set)
            
            col_set.remove(col)
            diag_set.remove(diag_num)
            anti_diag_set.remove(anti_diag_num)
            board[row][col]='.'