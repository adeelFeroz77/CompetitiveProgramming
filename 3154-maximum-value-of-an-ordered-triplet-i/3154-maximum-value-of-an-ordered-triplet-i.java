class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int n = nums.length;

        int maxi = 0, diffMax = 0;
        for (int num: nums) {
            ans = Math.max(ans, (long) diffMax * num);
            diffMax = Math.max(diffMax, maxi - num);
            maxi = Math.max(maxi, num);
        }

        return ans;
    }
}