class Solution {
    public boolean checkIfExist(int[] arr) {
        // brute force
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i != j){
                    int x = arr[i];
                    int y = arr[j];
                    if(x*2 == y || (y%2==0 && y/2 == x)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}