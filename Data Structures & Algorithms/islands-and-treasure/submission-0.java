class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
    
    public void islandsAndTreasure(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length, INF = 2147483647;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j]==0) q.offer(new int[]{i,j});
            }
        }

        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];

                for(int[] dir:dirs){
                    int newX = x + dir[0], newY = y + dir[1];
                    if(inBounds(rooms,newX,newY) && rooms[newX][newY]==INF){
                        rooms[newX][newY] = dist;
                        q.offer(new int[]{newX,newY});
                    }
                }
            }
            dist+=1;
        }


    }

    private boolean inBounds(int[][] grid, int x, int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }
}