class Solution {
    int[][] dirs = {{-1,0},{0,-1},{0,1},{1,0}};

    public int orangesRotting(int[][] grid) {
        int fresh = 0, m = grid.length, n = grid[0].length, time = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) fresh+=1;
                else if(grid[i][j]==2) q.offer(new int[]{i,j});
            }
        }

        while(!q.isEmpty() && fresh>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];

                for(int[] dir:dirs){
                    int newX = x + dir[0], newY = y + dir[1];

                    if(inBounds(grid,newX,newY) && grid[newX][newY]==1){
                        grid[newX][newY] = 2;
                        q.offer(new int[]{newX,newY});
                        fresh-=1;
                    }
                }
            }
            time+=1;
        }

        return fresh==0?time:-1;
    }

    private boolean inBounds(int[][] grid, int x, int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }
}