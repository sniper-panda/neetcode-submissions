class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];
        for(char[] x:board){
            Arrays.fill(x,'.');
        }

        solve(board,0,ans);
        return ans;
    }

    private void solve(char[][] board, int row, List<List<String>> ans){
        if(row>=board.length){
            List<String> smallAns = new ArrayList<>();
            for(char[] r:board){
                smallAns.add(new String(r));
            }
            ans.add(smallAns);
            return;
        }

        for(int col=0;col<board.length;col++){
            if(isValid(board,row,col)){
                board[row][col] = 'Q';

                solve(board,row+1,ans);
                
                board[row][col] = '.';
            }
        }

    }

    private boolean isValid(char[][] board, int row, int col){
        // Check Upwards
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q') return false;
        }

        // Upwards Diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        // Upwards Anti-Diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }

        return true;
    }
}