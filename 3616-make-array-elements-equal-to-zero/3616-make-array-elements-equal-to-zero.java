class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int [] sum = new int[n];

        sum[0] = nums[0];

        for(int i=1; i<n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] != 0) {
                continue;
            }

            int left = sum[i];
            int right = sum[n-1] - sum[i];

            if(left - right == 0) ans += 2;
            if(Math.abs(left-right) == 1) ans++;
        }
        return ans;

    }
}