class Solution {
    public boolean canSortArray(int[] nums) {
        int prevMax = Integer.MIN_VALUE;
        int curMax = nums[0];
        int curMin = nums[0];
        int n = nums.length;
        int sb = Integer.bitCount(nums[0]);
        for(int i=1;i<n;i++){
            int curSB = Integer.bitCount(nums[i]);
            if(curSB == sb){
                curMax = Math.max(nums[i], curMax);
                curMin = Math.min(nums[i], curMin);
                continue;
            }
            // last's max must be greater than current's min
            if(prevMax > curMin){
                return false;
            }
            prevMax = curMax;
            curMax = nums[i];
            curMin = nums[i];
            sb = curSB;
        }
        // last max must be greater
        return prevMax < curMin;
    }
}