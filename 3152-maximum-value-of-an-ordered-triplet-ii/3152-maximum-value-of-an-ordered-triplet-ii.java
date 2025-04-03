class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0;
        long maxi = 0, maxDiff = 0;

        for(int i: nums){
            res = Math.max(res, (long) (i * maxDiff));
            maxDiff = Math.max(maxDiff, maxi-i);
            maxi = Math.max(maxi, i);
        }

        return res;
    }
}