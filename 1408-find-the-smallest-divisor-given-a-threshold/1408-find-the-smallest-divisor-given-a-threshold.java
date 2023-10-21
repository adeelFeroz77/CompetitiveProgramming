class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int start = 1, end = 100000000;
        while (start <= end) {
            int mid = (start+end)/2;
            int sum = 0;
            for(int i=0;i<n;i++){
                sum+= (nums[i]/mid);
                if(nums[i]%mid!=0){
                    sum++;
                }
            }
            if(sum<=threshold){
                ans = Math.min(ans,mid);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}