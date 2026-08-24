class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};

    private boolean isBoundary(char[][] board, int i, int j){
        return i==0 || i==board.length-1 || j==0 || j==board[0].length-1;
    }

    private boolean inBounds(char[][] board, int i, int j){
        return i>=0 && i<board.length && j>=0 && j<board[0].length;
    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isBoundary(board,i,j) && board[i][j]=='O'){
                    q.offer(new int[]{i,j});
                    board[i][j] = '#';
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];

                for(int[] dir:dirs){
                    int newX = x + dir[0], newY = y + dir[1];
                    if(inBounds(board,newX,newY) && board[newX][newY]=='O'){
                        board[newX][newY] = '#';
                        q.offer(new int[]{newX,newY});
                    }
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