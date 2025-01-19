class Solution {
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int [] sum = new int[n];
        sum[0] = nums[0];
        for(int i=1; i<n; i++){
            sum[i] += nums[i]+sum[i-1];
        }
        int start = 0;
        int ans = nums[0];
        for(int i=1; i<n; i++){
            start = Math.max(0, i-nums[i]);
            ans += sum[i];
            if(start-1 >= 0) {
                ans -= sum[start -1];
            }
        }
        return ans;
    }
}