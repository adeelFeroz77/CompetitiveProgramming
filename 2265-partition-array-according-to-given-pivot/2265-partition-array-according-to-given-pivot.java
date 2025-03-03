class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int smaller = 0;
        int equal = 0;
        int greater = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == pivot){
                equal++;
            }else if(nums[i] < pivot){
                smaller++;
            }else{
                greater++;
            }
        }
        int i = 0, j = smaller, k = smaller+equal;
        int [] ans = new int[n];

        for(int x=0; x<n; x++){
            if(nums[x] < pivot){
                ans[i++] = nums[x]; 
            }else if(nums[x] > pivot){
                ans[k++] = nums[x];
            }else{
                ans[j++] = nums[x];
            }
        }

        return ans;
    }
}