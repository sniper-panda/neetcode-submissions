class UnionFind {
    private int[] parent;
    private int[] rank; 

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
	
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX != parentY) {
            if (rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX;
            } else if (rank[parentX] < rank[parentY]) {
                parent[parentX] = parentY;
            } else {
                parent[parentY] = parentX;
                rank[parentX] += 1;
            }
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n+1);

        for(int[] edge:edges){
            if(!uf.isConnected(edge[0],edge[1])){
                uf.union(edge[0],edge[1]);
            }else{
                return edge;
            }
        }

        return new int[]{};
    }
}