class Solution {
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;

        long low = 1, high = 100000000000007L;
        long ans = 0;
        while(low <= high){
            long mid = (low+high)/2;
            if(valid(ranks, cars, mid)){
                high = mid -1;
                ans = mid;
            }else{
                low = mid +1;
            }
        }
        return ans;
    }

    public boolean valid(int [] ranks, int cars, long val){
        for(int i=0; i<ranks.length && cars > 0; i++){
            long x  = val / ranks[i];
            long lower = (long)Math.floor(Math.sqrt(x));
            if(ranks[i] * lower * lower <= val){
                cars -= lower;
            }
        }
        return cars <= 0;
    }
}