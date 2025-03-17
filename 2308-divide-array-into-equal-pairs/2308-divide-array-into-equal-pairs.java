class Solution {
    public boolean divideArray(int[] nums) {
        int [] count = new int[501];
        int n = nums.length;
        for(int i=0; i<n; i++){
            count[nums[i]]++;
        }

        for(int i=0; i<501; i++){
            if(count[i] %2 != 0){
                return false;
            }
        }
        return true;
    }
}