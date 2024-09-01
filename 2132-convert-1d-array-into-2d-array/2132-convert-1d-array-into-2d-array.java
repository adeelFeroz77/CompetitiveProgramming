class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length!=n*m){
            return new int[0][];
        }
        int [][] arr = new int[m][n];
        int r = 0, c = 0;
        for(int i=0;i<original.length;i++){
            arr[r][c] = original[i];
            c++;
            if(c==n){
                c=0;
                r++;
            }
        }
        return arr;
    }
}