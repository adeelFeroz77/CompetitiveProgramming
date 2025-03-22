class Solution {
    public int countCompleteComponents(int n, int[][] e) {
        int [] parent = new int[n];
        int [] size = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int i=0; i<e.length; i++){
            int u = e[i][0];
            int v = e[i][1];

            int parent_u = find(u, parent);
            int parent_v = find(v, parent);

            if(parent_u != parent_v){
                union(parent_u, parent_v, parent, size);
            }
        }

        int [] edges = new int[n];
        for(int i=0; i<e.length; i++){
            int u = e[i][0];
            int p = find(u, parent);
            edges[p]++;
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            int nodes = size[i];
            if(parent[i] == i && edges[i] == nodes*(nodes-1)/2){
                ans++;
            }
        }
        return ans;
    }

    public int find(int x, int [] parent){
        if(parent[x] == x){
            return x;
        }
        parent[x] = find(parent[x], parent);
        return parent[x];
    }

    public void union(int u, int v, int [] parent, int [] size){
        if(size[u] > size[v]){
            parent[v] = u;
            size[u] += size[v];
        }else{
            parent[u] = v;
            size[v] += size[u];
        }
    }
}