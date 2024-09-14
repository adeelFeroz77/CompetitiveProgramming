class Solution {
    public int longestSubarray(int[] nums) {
        int maxi = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            maxi = Math.max(maxi, nums[i]);
        }
        int maxCons = 0;
        int curr = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == maxi){
                curr++;
            }else{
                maxCons = Math.max(maxCons, curr);
                curr = 0;
            }
        }
        maxCons = Math.max(curr, maxCons);
        return maxCons;
    }
}