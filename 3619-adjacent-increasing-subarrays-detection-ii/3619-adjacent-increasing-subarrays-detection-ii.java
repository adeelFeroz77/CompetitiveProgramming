class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int maxi = 0, prev = 0, curr = 1;

        for(int i=1; i<n; i++) {
            if(nums.get(i) > nums.get(i-1)) {
                curr++;
            } else {
                // 2 options, either divide current in half
                // or get the min or curr and prev

                maxi = Math.max(maxi, Math.max(curr/2, Math.min(prev, curr)));
                prev = curr;
                curr = 1;
            }
        }
        maxi = Math.max(maxi, Math.max(curr/2, Math.min(prev, curr)));
        return maxi;
    }
}