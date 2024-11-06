class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = 0;
        int n = piles.length;
        for(int i=0; i<n; i++){
            maxi = Math.max(piles[i], maxi);
        }
        int i=1, j=maxi;
        int ans = maxi;
        while(i<=j){
            int mid = (i+j)/2;
            long reqHours = 0;
            for(int k = 0;k<n;k++){
                if(piles[k] <= mid){
                    reqHours++;
                }else{
                    reqHours += piles[k]/mid + (piles[k]%mid!=0? 1: 0);
                }
            }
            if(reqHours <= h){
                ans = Math.min(mid, ans);
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        return ans;
    }
}