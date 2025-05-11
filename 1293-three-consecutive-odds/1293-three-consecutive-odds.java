class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        if (n < 3){
            return false;
        }
        for(int i=0; i+2<n; i++){
            if(arr[i]%2==1 && arr[i+1]%2==1 && arr[i+2]%2==1){
                return true;
            }
        }
        return false;
    }
}