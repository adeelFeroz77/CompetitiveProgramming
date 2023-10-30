class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] visited = new int[n][m];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    islandDFS(i,j,grid,visited);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void islandDFS(int i, int j, char [][] grid,int [][] visited){
        visited[i][j] = 1;
        int [] delRow = {-1,0,1,0};
        int [] delCol = {0,1,0,-1};
        for(int x=0;x<4;x++){
            int nRow = i + delRow[x];
            int nCol = j + delCol[x];
            if(nRow>=0 && nRow<grid.length && nCol>=0 && nCol<grid[0].length &&
                visited[nRow][nCol] == 0 && grid[nRow][nCol] == '1'){
                islandDFS(nRow,nCol,grid,visited);
            }
        }
    }
}