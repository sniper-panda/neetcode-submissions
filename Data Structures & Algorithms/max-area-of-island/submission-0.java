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

                    dfs(grid,i,j,currArea);
                    maxArea = Math.max(maxArea,currArea[0]);
                }
            }
        }

        return maxArea;
    }

    private void dfs(int[][] grid, int x, int y, int[] currArea){
        grid[x][y] = 0;
        
        for(int[] dir:dirs){
            int newX = dir[0] + x;
            int newY = dir[1] + y;

            if(inBounds(grid,newX,newY) && grid[newX][newY]==1){
                currArea[0]+=1;
                dfs(grid,newX,newY,currArea);
            }
        }
    }

    private boolean inBounds(int[][] grid, int x, int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }
}