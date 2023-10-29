class Solution {
    public int splitArray(int[] nums, int k) {
        int min = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            min = Math.max(min,nums[i]);
            max += nums[i];
        }
        int start= min;
        int end = max;
        int ans = 1000000009;
        while(start<=end){
            int mid = (start+end)/2;
            int partitions = 1;
            int sum = 0;
            for(int i=0;i<nums.length;i++){
                if(sum + nums[i] <= mid){
                    sum+=nums[i];
                }else{
                    partitions++;
                    sum = nums[i];
                }
            }
            if(partitions>k){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return end+1;
    }
}