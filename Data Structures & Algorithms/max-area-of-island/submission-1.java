class Solution {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int maxArea = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int[] currArea = new int[1];
                    currArea[0] = 1;

                    bfs(grid,i,j,currArea);
                    maxArea = Math.max(maxArea,currArea[0]);
                }
            }
        }

        return maxArea;
    }

    private void bfs(int[][] grid, int x, int y, int[] currArea){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        grid[x][y] = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int[] dir:dirs){
            int newX = dir[0] + curr[0];
            int newY = dir[1] + curr[1];

            if(inBounds(grid,newX,newY) && grid[newX][newY]==1){
                currArea[0]+=1;
                q.offer(new int[]{newX,newY});
                grid[newX][newY]=0;
            }
        }
    } 
}

    private boolean inBounds(int[][] grid, int x, int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }
}