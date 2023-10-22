class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean [] visited = new boolean[isConnected.length];
        int ans = 0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                ans++;
                dfs(i,visited,adj,new ArrayList<>());
            }
        }
        return ans;
    }

    public static void dfs(int node, boolean [] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> df){
        visited[node] = true;
        df.add(node);
        for(Integer n: adj.get(node)){
            if(!visited[n])
                dfs(n,visited,adj,df);
        }
    }
}