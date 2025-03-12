class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                pos++;
                continue;
            }
            if(nums[i] < 0)
                neg++;
        }

        return Math.max(pos,neg);
    }
}