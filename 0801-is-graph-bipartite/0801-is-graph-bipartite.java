class Solution {
    public static boolean bipartiteDFS(int node, int[][]graph, int [] color, int col){
        color[node] = col;
        for(int i =0;i<graph[node].length;i++){
            if(color[graph[node][i]]==-1){
                if(!bipartiteDFS(graph[node][i], graph, color, (col == 0) ? 1 : 0)){
                    return false;
                }
            }else{
                if(color[graph[node][i]]==col){
                    return false;
                }
            }
        }
        return true;
    }


    public boolean isBipartite(int[][] graph) {
        int [] color = new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                if(!bipartiteDFS(i,graph,color,0)){
                    return false;
                }
            }
        }
        return true;
    }
}