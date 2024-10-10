class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for(int i=0;i<n;i++){
            int [] freq = new int[101];
            int row = i;
            int j=0;
            while(row<n && j<m){
                freq[mat[row][j]]++;
                row++;
                j++;
            }
            row = i;
            j=0;
            for(int k=0;k<101;k++){
                if(freq[k]>0){
                    mat[row][j] = k;
                    freq[k]--;
                    k--;
                    row++;
                    j++;
                }
            }
        }

        for(int i=1;i<m;i++){
            int [] freq = new int[101];
            int col = i;
            int j=0;
            while(j<n && col<m){
                freq[mat[j][col]]++;
                col++;
                j++;
            }
            col = i;
            j=0;
            for(int k=0;k<101;k++){
                if(freq[k]>0){
                    mat[j][col] = k;
                    freq[k]--;
                    k--;
                    col++;
                    j++;
                }
            }
        }

        return mat;
    }
}