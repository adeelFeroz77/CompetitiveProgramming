class Solution {
    List<List<Pair>> adjList = new ArrayList<>();

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int visitedCount = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build adjacency list with Manhattan distances
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adjList.get(i).add(new Pair(i, j, dist));
                adjList.get(j).add(new Pair(j, i, dist));
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        // Start from point 0
        visited[0] = true;
        visitedCount++;
        pq.addAll(adjList.get(0));

        while (!pq.isEmpty() && visitedCount < n) {
            Pair p = pq.poll();
            if (visited[p.v]) continue;

            visited[p.v] = true;
            visitedCount++;
            ans += p.cost;

            for (Pair neighbor : adjList.get(p.v)) {
                if (!visited[neighbor.v]) {
                    pq.add(neighbor);
                }
            }
        }

        return ans;
    }
}

class Pair {
    int u;
    int v;
    int cost;

    Pair(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }
}
