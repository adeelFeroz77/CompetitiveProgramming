import java.util.*;
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] visited = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j] = -1;
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==-1){
                    ans = Math.max(ans,longestIncreasingDFS(i,j,matrix,visited));
                }
            }
        }
        return ans;
    }

    public static int longestIncreasingDFS(int i, int j, int[][] matrix, int [][] visited){
        int n = matrix.length;
        int m = matrix[0].length;
        visited[i][j] = 0;
        int [] delRow = {-1,0,1,0};
        int [] delCol = {0,1,0,-1};
        int maxi = 1;
        for(int x=0;x<4;x++){
            int nRow = i + delRow[x];
            int nCol = j + delCol[x];
            if( nRow>=0 && nRow<n && nCol>=0 && nCol<m &&
                matrix[nRow][nCol] > matrix[i][j]){
                if(visited[nRow][nCol] == -1){
                    maxi = Math.max(maxi,1+longestIncreasingDFS(nRow,nCol,matrix,visited));
                }else{
                    maxi = Math.max(maxi,1+visited[nRow][nCol]);
                }
            }
        }
        visited[i][j] = maxi;
        return maxi;

    }
}