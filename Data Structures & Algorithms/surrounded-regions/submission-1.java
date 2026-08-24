class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};

    private boolean isBoundary(char[][] board, int i, int j){
        return i==0 || i==board.length-1 || j==0 || j==board[0].length-1;
    }

    private boolean inBounds(char[][] board, int i, int j){
        return i>=0 && i<board.length && j>=0 && j<board[0].length;
    }

    private void dfs(char[][] board, int i, int j){
        board[i][j] = '#';

        for(int[] dir:dirs){
            int newX = i + dir[0], newY = j + dir[1];

            if(inBounds(board,newX,newY) && board[newX][newY]=='O'){
                dfs(board,newX,newY);
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isBoundary(board,i,j) && board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='#') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
}