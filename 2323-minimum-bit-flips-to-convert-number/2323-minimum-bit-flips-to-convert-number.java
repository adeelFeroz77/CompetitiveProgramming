class Solution {
    public int minBitFlips(int start, int goal) {
        int diff = start^goal;
        int ans = 0;
        while(diff!=0){
            ans += diff&1;
            diff>>=1;
        }
        return ans;
    }
}