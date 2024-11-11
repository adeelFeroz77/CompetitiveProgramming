class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        int [] seive = new int[1001];
        Arrays.fill(seive, 1);
        seive[0] = 0;
        seive[1] = 0;
        
        for(int i=2; i*i<1001; i++){
            if(seive[i] == 1){
                for(int j=i*i; j<1001; j+=i){
                    seive[j] = 0; 
                }
            }
        }


        for(int i=0; i<n; i++){
            int idx = nums[i]-1;
            while(idx > 0){
                if(seive[idx] == 1){
                    if((i>0 && nums[i]-idx > nums[i-1]) || (i == 0)){
                        // System.out.println(i + "-> " + idx);
                        nums[i]-= idx;
                        break;
                    }
                }
                idx--;
            }
            // if(idx == 0){
            //     return false;
            // }
        }

        System.out.println(Arrays.toString(nums));

        for(int i=1;i<n;i++){
            if(nums[i]<=nums[i-1]){
                return false;
            }
        }
        return true;
    }
}