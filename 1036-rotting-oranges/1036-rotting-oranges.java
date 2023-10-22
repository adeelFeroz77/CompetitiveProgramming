class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int [][] visited = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j,0));
                    visited[i][j] = 1;
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty()){
            Pair p = queue.remove();
            time = p.time;
            int drow[] = {-1,0,1,0};
            int dcol[] = {0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow = p.row + drow[i];
                int ncol = p.col + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m
                    && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    queue.add(new Pair(nrow,ncol,p.time+1));
                    visited[nrow][ncol] = 1;
                    grid[nrow][ncol] = 2;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time;
    }
}

class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}