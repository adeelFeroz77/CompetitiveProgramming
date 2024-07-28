class Solution {
    public boolean canAliceWin(int[] nums) {
        int total = 0;
        int single = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]<10){
                single += nums[i];
            }
            total += nums[i];
        }

        if(single > total - single || total - single > single){
            return true;
        }
        return false;
    }
}