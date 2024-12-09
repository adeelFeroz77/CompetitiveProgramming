class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int [] arr = new int[n];
        int val = 0;
        for(int i=1; i<n; i++){
            if(nums[i]%2 == nums[i-1]%2){
                val++;
            }
            arr[i] = val;
        }
        boolean [] ans = new boolean[queries.length];
        for(int i=0; i<queries.length; i++){
            ans[i] = arr[queries[i][0]] == arr[queries[i][1]];
        }
        return ans;
    }
}