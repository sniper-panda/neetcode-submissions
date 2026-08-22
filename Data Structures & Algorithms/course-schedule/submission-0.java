class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        int n = numCourses;
        int[] indegree = new int[n];

        for(int[] prereq:prerequisites){
            int src = prereq[1], dest = prereq[0];
            adjMap.computeIfAbsent(src,k->new ArrayList<>()).add(dest);
            indegree[dest]+=1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.offer(i);
        }

        int coursesDone = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            coursesDone+=1;

            for(int v:adjMap.getOrDefault(curr,new ArrayList<>())){
                indegree[v]-=1;
                if(indegree[v]==0) q.offer(v);
            }
        }

        return coursesDone==n;
    }
}