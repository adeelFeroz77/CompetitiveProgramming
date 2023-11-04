class Solution {

    public int substringExists(int index, int target, int [][] dp, int[] nums){
        if(index==0){
            if(target==nums[0]){
                return 1;
            }
            return 0;
        }
        if(target==0){
            return 1;
        }
        if(dp[index][target]!=-1){
            return dp[index][target];
        }
        int notTake= substringExists(index-1,target,dp,nums);
        int take = 0;
        if(target>=nums[index]){
            take = substringExists(index-1, target-nums[index], dp, nums);
        }
        dp[index][target] = Math.max(take,notTake);
        return dp[index][target];
    }

    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;
        int [][] dp = new int[nums.length][target+1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=target;j++){
                dp[i][j] = -1;
            }
        }
        return substringExists(nums.length - 1, target, dp, nums) == 1;
    }
}