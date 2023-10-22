class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int [][] visited = new int[image.length][image[0].length];
        floodFillDFS(sr,sc,image,color,visited);
        return image;
    }

    public void floodFillDFS(int row,int col,int [][] image, int color,int[][] visited){
        int val = image[row][col];
        image[row][col] = color;
        visited[row][col] = 1;
        int [] drow = {-1,0,1,0};
        int [] dcol = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];
            if(nrow>=0 && nrow<image.length && ncol>=0 && ncol<image[0].length
               && image[nrow][ncol]==val && visited[nrow][ncol]==0){
                floodFillDFS(nrow,ncol,image,color,visited);
            }
        }
    }
}