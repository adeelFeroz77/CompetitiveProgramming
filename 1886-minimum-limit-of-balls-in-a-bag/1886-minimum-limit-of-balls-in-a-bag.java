class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 1000000001;
        while(left <= right){
            int mid = (left+right)/2;
            int cnt = 0;
            for(int i=0; i<nums.length; i++){
                cnt += (nums[i]-1)/mid;
            }
            if(cnt > maxOperations){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return left;
    }
}