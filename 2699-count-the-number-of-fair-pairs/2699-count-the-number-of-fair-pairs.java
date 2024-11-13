class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return count(upper, nums) - count(lower-1, nums);
    }

    public static long count(int target, int [] nums){
        int i = 0, j = nums.length-1;
        long res = 0;
        while(i<j){
            if(nums[i] + nums[j] > target){
                j--;
            }else{
                res += j-i;
                i++;
            }
        }
        return res; 
    }
}