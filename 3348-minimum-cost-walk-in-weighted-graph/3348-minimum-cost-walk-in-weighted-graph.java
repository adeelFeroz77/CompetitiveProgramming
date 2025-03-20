class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int [] parent = new int[n];
        int [] cost = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            cost[i] = -1;
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            int parentU = find(u, parent);
            int parentV = find(v, parent);

            if(parentU != parentV){
                parent[parentV] = parentU;
                cost[parentU] &= cost[parentV]; 
            }

            cost[parentU] &= w;
        }

        int [] ans = new int[query.length];
        for(int i=0; i<query.length; i++){
            int u = query[i][0];
            int v = query[i][1];

            if(u == v){
                ans[i] = 0;
                continue;
            }

            int parentU = find(u, parent);
            int parentV = find(v, parent);

            if(parentU != parentV){
                ans[i] = -1;
                continue;
            }

            ans[i] = cost[parentU];
        }

        return ans;
    }

    private int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x], parent);
    }
    
}