class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i: nums){
            int x = Math.abs(i);
            if(nums[x-1] >0)
                nums[x-1] = -nums[x-1];
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= 0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}