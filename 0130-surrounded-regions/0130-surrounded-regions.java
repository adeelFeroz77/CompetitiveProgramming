class Solution {
    public static void boardDFS(int row, int col, char[][] board, int[][]visited){
        int n = board.length;
        int m = board[0].length;
        visited[row][col] = 1;
        int [] delRow = {-1,0,1,0};
        int [] delCol = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m
               && visited[nRow][nCol] == 0 && board[nRow][nCol] == 'O' ){
                boardDFS(nRow,nCol,board,visited);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int [][] visited = new int[n][m];
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && visited[0][i]==0){
                boardDFS(0,i,board,visited);
            }
            if(board[n-1][i]=='O' && visited[n-1][i]==0){
                boardDFS(n-1,i,board,visited);
            }
        }
        for(int i=1;i<n;i++){
            if(board[i][0]=='O' && visited[i][0]==0){
                boardDFS(i,0,board,visited);
            }
            if(board[i][m-1]=='O' && visited[i][m-1]==0){
                boardDFS(i,m-1,board,visited);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0){
                    board[i][j] = 'X';
                }
            }
        }
    }
}