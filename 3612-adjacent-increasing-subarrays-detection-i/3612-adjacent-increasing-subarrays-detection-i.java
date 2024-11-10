class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int m) {
        int i=0;
        int j = i+m;
        boolean ans = false;
        int n = nums.size();
        boolean reCheck = false;
        while(j<n && i+m <= j && j+m <= n){
            int lastI = nums.get(i);
            int lastJ = nums.get(j);
            reCheck = false;
            System.out.println(i + " " + j);
            for(int k = i+1; k<j ;k++){
                if(nums.get(k) <= lastI){
                    i++;
                    j++;
                    reCheck = true;
                    break;
                }
                lastI = nums.get(k);
            }
            if(reCheck){
                continue;
            }
            for(int k = j+1; k<j+m && k <n; k++){
                if(nums.get(k) <= lastJ){
                    i++;
                    j++;
                    reCheck = true;
                    break;
                }
                lastJ = nums.get(k);
            }
            if(reCheck){
                continue;
            }
            return true;
        }
        return false;
    }
}