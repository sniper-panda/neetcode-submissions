class UnionFind{
    public int[] parent;
    public int[] rank;

    UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public boolean isConnected(int x, int y){
        return find(x)==find(y);
    }

    public int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x,int y){
        int parentX = find(x);
        int parentY = find(y);

        if(parentX==parentY) return;

        if(rank[parentX] > rank[parentY]){
            parent[parentY] = parentX;
        }else if(rank[parentY] > rank[parentX]){
            parent[parentX] = parentY;
        }else{
            rank[parentX]+=1;
            parent[parentY] = parentX;
        }
    }
}

class Solution {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        UnionFind uf = new UnionFind(m*n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) continue;

                int curr = i * n + j;
                for (int[] dir : dirs) {

                    int newX = i + dir[0];
                    int newY = j + dir[1];

                    if (!inBounds(grid, newX, newY) || grid[newX][newY] == 0) continue;
                        int next = newX * n + newY;
                        uf.union(curr, next);
                }
            }
        }

        Map<Integer, Integer> islandMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) continue;

                int cell = i * n + j;
                int root = uf.find(cell);

                islandMap.put(
                    root,
                    islandMap.getOrDefault(root, 0) + 1
                );
            }
        }

        int maxArea = 0;
        for (int area : islandMap.values()) {
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
}

    private boolean inBounds(int[][] grid, int x, int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }
}