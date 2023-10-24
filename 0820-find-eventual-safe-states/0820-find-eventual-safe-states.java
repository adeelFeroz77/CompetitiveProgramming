class Solution {

    public static boolean safeDFS(int node, int [] visited, List<List<Integer>> adj, int [] isSafe, int [] isTerminal){
        if(isTerminal[node]==1){
            visited[node] = 1;
            isSafe[node] = 1;
            return true;
        }
        visited[node] = 1;
        boolean ans = true;
        for(Integer n: adj.get(node)){
            if(visited[n]==0){
                ans = ans && safeDFS(n,visited,adj,isSafe,isTerminal);
            }else{
                ans = ans && isSafe[n]==1;
            }
        }
        isSafe[node] = (ans)?1:0;
        return ans;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int [] visited = new int[V];
        int [] isSafe = new int[V];
        int [] isTerminal = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        for(int i=0;i<adj.size();i++){
            if(adj.get(i).size()==0){
                isTerminal[i] = 1;
            }
        }
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                safeDFS(i,visited,adj,isSafe,isTerminal);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(isSafe[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }
}