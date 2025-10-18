class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int mini = Integer.MIN_VALUE;
        int ans = 0;

        for(int i=0; i<n; i++) {
            int num = nums[i];
            int prev = mini;
            mini = Math.max(mini+1, num-k);
            // System.out.println(mini);

            if(mini >= num-k && mini <= num+k){
                ans++;
            } else{
                mini = prev;
            }
        }

        return ans;
    }
}