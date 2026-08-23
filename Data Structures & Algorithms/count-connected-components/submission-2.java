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
                bfs(i,adjList,visited);
            }
        }

        return count;
    }

    private void bfs(int u,List<List<Integer>> adjList, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(u);
        visited[u] = true;

        while(!q.isEmpty()){
            int currNode = q.poll();
            for(int v:adjList.get(currNode)){
                if(!visited[v]){
                    q.offer(v);
                    visited[v] = true;
                } 
            }
        }
    }
}