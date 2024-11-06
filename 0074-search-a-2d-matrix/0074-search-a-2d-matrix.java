class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = -1;
        int col = -1;
        int i=0, j =n-1;
        while(i<=j){
            int mid = (i+j)/2;
            int first = matrix[mid][0];
            int last = matrix[mid][m-1];
            if(target>= first && target <= last){
                row = mid;
                break;
            }else if(target<first){
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        if(row == -1){
            return false;
        }
        i = 0; j = m-1;
        while(i <= j){
            int mid = (i+j)/2;
            if(target == matrix[row][mid]){
                return true;
            }else if(target > matrix[row][mid]){
                i = mid+1;
            }else{
                j = mid-1;
            }
        }
        return false;
    }
}