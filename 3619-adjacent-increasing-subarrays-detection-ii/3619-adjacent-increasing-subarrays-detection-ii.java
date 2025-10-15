class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int left = 0, right = n/2 + 1;
        int ans = 1;
        while(left < right) {
            int k = (left + right) >> 1;
            if(increasingSubArrays(nums, k)) {
                left = k+1;
                ans = k;
            } else {
                right = k;
            }
        }
        return ans;
    }

    public boolean increasingSubArrays(List<Integer> nums, int k) {
        if (k == 1) return true; 
        for (int i = 0, j = k, max = 1; j< nums.size()-1; i++, j++) {
            if (nums.get(i) < nums.get(i + 1) && nums.get(j) < nums.get(j + 1)) {
                max++;
                if (max == k) {
                    return true;
                }
            } else {
                max = 1;
            }
        }
        return false;
    }  
}