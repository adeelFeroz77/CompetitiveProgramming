class Solution {
    public boolean check(int[] nums) {
        int min = nums[0];
        int idx = 0;

        for(int i=1; i<nums.length; i++){
            if(nums[i] < nums[i-1]){
                idx = i;
                min = nums[i];
            }
        }
        int prev = min;
        for(int i=idx+1; i<nums.length; i++){
            if(nums[i] < prev){
                return false;
            }
            prev = nums[i];
        }

        for(int i=0; i<idx; i++){
            if(nums[i] < prev){
                return false;
            }
            prev = nums[i];
        }

        return true;
    }
}