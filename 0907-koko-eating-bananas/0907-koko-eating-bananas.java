class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = -1;
        for(int i=0;i<piles.length;i++){
            maxi = Math.max(maxi,piles[i]);
        }
        int start = 1;
        int end = maxi;
        while(start<=end){
            int mid = (start+end)/2;
            if(calculateHours(piles,mid)<=h){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    public static int calculateHours(int [] arr, int hours){
        int h = 0;
        for(int i=0;i<arr.length;i++){
            h+= Math.ceil((double) arr[i] /hours);
        }
        return h;
    }
}