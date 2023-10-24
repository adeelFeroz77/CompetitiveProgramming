class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] indegrees = new int[numCourses];
        int [] visited = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            indegrees[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }
        int [] topo = new int[numCourses];
        int i=0;
        while(!q.isEmpty()){
            int node = q.remove();
            topo[i] = node;
            i++;
            visited[node] = 1;
            for(Integer n: adj.get(node)){
                indegrees[n]--;
                if(indegrees[n]==0 && visited[n]==0){
                    q.add(n);
                }
            }
        }
        if(i==numCourses){
            return topo;
        }
        return new int[]{};
    }
}