class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            int u = i;
            int v = favorite[i];

            adj.get(v).add(u);
        }

        int maxCycle = 0;
        int leastCombinedCycles = 0; // cycles of length 2

        boolean [] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                Map<Integer, Integer> map = new HashMap<>();
                int currentNode = i;
                int currentCount = 0;

                while (!visited[currentNode]){
                    visited[currentNode] = true;
                    map.put(currentNode, currentCount);

                    int nextNode = favorite[currentNode];
                    currentCount++;

                    if(map.containsKey(nextNode)){
                        // cycle detected
                        int lastCount = map.getOrDefault(nextNode, 0);

                        int cycleLength = currentCount - lastCount;

                        if(cycleLength == 2){
                            boolean [] bfsVisited = new boolean[n];
                            bfsVisited[currentNode] = true;
                            bfsVisited[nextNode] = true;
                            leastCombinedCycles += 2 + BFS(currentNode, adj, bfsVisited) + BFS(nextNode, adj, bfsVisited);
                        }
                        maxCycle = Math.max(maxCycle, cycleLength);

                        break;
                    }
                    currentNode = nextNode;
                }
            }
        }
        return Math.max(maxCycle, leastCombinedCycles);

    }

        public int BFS(int node, List<List<Integer>> adj, boolean [] visited){
        Queue<int [] > queue = new LinkedList<>();
        queue.add(new int[]{node, 0});
        int maxi = 0;
        while(!queue.isEmpty()){
            int [] p = queue.poll();
            int currentNode = p[0];
            int value = p[1];

            for(int i: adj.get(currentNode)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(new int[]{i, value+1});
                    maxi = Math.max(maxi, value+1);
                }
            }
        }
        return maxi;
    }
}
