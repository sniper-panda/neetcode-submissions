class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(i,new ArrayList<>());
        }

        for(int[] edge:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,adjList,visited);
            }
        }

        return count;
    }

    private void dfs(int u,List<List<Integer>> adjList, boolean[] visited){
        visited[u] = true;

        for(int v:adjList.get(u)){
            if(!visited[v]) dfs(v,adjList,visited);
        }
    }
}