class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Arrays.asList(0);

        List<Integer> ans = new ArrayList<>();
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();

        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        for(int[] edge:edges){
            int src = edge[0],dest = edge[1];
            adjMap.computeIfAbsent(src,k->new ArrayList<>()).add(dest);
            adjMap.computeIfAbsent(dest,k->new ArrayList<>()).add(src);
            indegree[src]+=1;
            indegree[dest]+=1;
        }

        for(int i=0;i<n;i++){
            if(indegree[i]==1) q.offer(i);
        }

        while(n > 2){
            int size = q.size();
            n-=size;

            for(int k=0;k<size;k++){
                int curr = q.poll();

                for(int v:adjMap.getOrDefault(curr,new ArrayList<>())){
                    indegree[v]-=1;
                    if(indegree[v]==1) q.offer(v);
                }
            }
        }

        while(!q.isEmpty()) ans.add(q.poll());

        return ans;
    }
}