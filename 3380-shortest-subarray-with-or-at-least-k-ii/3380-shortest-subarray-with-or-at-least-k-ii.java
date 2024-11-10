class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int [] currentBits = new int[32];
        long currentOr = 0;
        int ans = Integer.MAX_VALUE;
        int i = 0, j =0, n = nums.length;
        while(j < n){
            if(nums[j] >= k){
                return 1;
            }
            currentOr |= nums[j];
            for(int l=0; l<32;l ++){
                currentBits[l] += (nums[j] & (1 << l));
            }
            while(currentOr >= k && i<=j){
                ans = Math.min(ans, j-i+1);
                for(int l=0; l<32; l++){
                    int x = nums[i];
                    currentBits[l] -= (x & (1 << l));
                    if(currentBits[l] == 0){
                        currentOr = (~(1<<l))&currentOr;
                    }
                }
                i++;
            }
            j++;
        }
        return ans == Integer.MAX_VALUE? -1 : ans;

    }
}