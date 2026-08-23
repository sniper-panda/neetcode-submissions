class UnionFind{
    private int[] parent;
    private int[] rank;

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
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;
        UnionFind uf = new UnionFind(n);

        for(int[] edge:edges){
            if(uf.isConnected(edge[0],edge[1])) return false;
            uf.union(edge[0],edge[1]);
        }

        return true;
    }
}