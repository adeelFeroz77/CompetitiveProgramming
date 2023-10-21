class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int ans = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        int n = bloomDay.length;
        if(m*k>n){
            return -1;
        }
        for(int i=0;i<n;i++){
            min = Math.min(bloomDay[i],min);
            maxi = Math.max(bloomDay[i],maxi);
        }
        int start = min;
        int end = maxi;
        while(start<=end){
            int mid = (start+end)/2;
            int currentCount = 0;
            int totalCount = 0;
            for(int i=0;i<n;i++){
                if(bloomDay[i]<=mid){
                    currentCount++;
                }else{
                    totalCount += (currentCount/k);
                    currentCount = 0;
                }
            }
            totalCount+=(currentCount/k);
            if(totalCount>=m){
                ans = Math.min(ans,mid);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return (ans==Integer.MAX_VALUE)?-1:ans;
    }
}