class Solution {
    public int findFinalValue(int[] nums, int original) {
        int [] vals = new int[1001];
        
        for(int num: nums){
            vals[num]++;
        }
        
        while(original<=1000 && vals[original]>0){
            original*=2;
        }
        return original;
    }
    
}