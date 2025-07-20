class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int [][] minCost = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                minCost[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);

        minCost[0][0] = grid[0][0];
        pq.add(new Pair(0, 0, minCost[0][0]));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            
            int [] delRow = {-1,0,1,0};
            int [] delCol = {0,1,0,-1};

            int row = p.x;
            int col = p.y;
            int cost = p.cost;

            for(int i=0; i<4; i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if( newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                    if(grid[newRow][newCol] <= cost && minCost[newRow][newCol] > cost){
                        pq.add(new Pair(newRow, newCol, cost));
                        minCost[newRow][newCol] = cost;
                    } else if (minCost[newRow][newCol] == Integer.MAX_VALUE){
                        pq.add(new Pair(newRow, newCol, grid[newRow][newCol]));
                        minCost[newRow][newCol] = grid[newRow][newCol];
                    }
                }
            }
        }

        return minCost[n-1][n-1];
    }
}

class Pair {
    int x;
    int y;
    int cost;

    Pair(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}