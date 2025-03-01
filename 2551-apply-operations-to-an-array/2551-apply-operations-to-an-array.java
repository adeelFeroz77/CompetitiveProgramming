class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1]){
                nums[i-1] *= 2;
                nums[i] = 0;
            }
        }
        int zeroIndex = -1;
        for(int i=0; i<n; i++){
            if(zeroIndex == -1 && nums[i] == 0){
                zeroIndex = i;
            }

            if(nums[i] != 0 && zeroIndex != -1){
                nums[zeroIndex] = nums[i];
                nums[i] = 0;
                while(nums[zeroIndex] != 0 && zeroIndex < n){
                    zeroIndex++;
                }
            }
        }
        return nums;
    }
}