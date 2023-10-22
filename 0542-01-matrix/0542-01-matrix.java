class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int [][] visited = new int[n][m];
        int [][] ans = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    queue.add(new Pair(i,j,0));
                    visited[i][j] = 1;
                }
            }
        }
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            ans[p.row][p.col] = p.time;
            int [] drow = {-1,0,1,0};
            int [] dcol = {0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow = p.row + drow[i];
                int ncol = p.col + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m
                   && visited[nrow][ncol] == 0 && mat[nrow][ncol] == 1 ){
                    visited[nrow][ncol] = 1;
                    queue.add(new Pair(nrow,ncol,p.time+1));
                }
            }
        }
        return ans;
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