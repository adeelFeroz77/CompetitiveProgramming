class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 1;
        int end = 100000000;
        int ans = Integer.MAX_VALUE;
        int n = weights.length;
        while(start<=end){
            int mid = (start+end)/2;
            int sum = 0;
            int d = 1;
            for(int i=0;i<n;i++){
                if(weights[i]>mid){
                    d = days+1;
                    break;
                }
                sum+=weights[i];
                if(sum>mid){
                    d++;
                    sum = weights[i];
                }
            }
            if(d<=days){
                ans = Math.min(ans,mid);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}