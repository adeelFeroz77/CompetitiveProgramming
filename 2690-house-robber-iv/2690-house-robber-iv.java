class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int low = 100000007;
        int high = -1;

        for(int i=0; i<n; i++){
            low = Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }

        int ans = 0;

        while(low <= high){
            int mid = (low+high+1)/2;
            if(isValid(nums, k, mid)){
                high = mid-1;
                ans = mid;
            }else{
                low = mid+1;
            }
        }
        return ans;

    }

    public boolean isValid(int [] nums, int k, int val){
        for(int i=0; i<nums.length && k > 0; i++){
            if(nums[i] <= val){
                k--;
                i++;
            }
        }

        return k<=0;
    }
}