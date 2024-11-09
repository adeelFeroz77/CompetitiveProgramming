class Solution {
    public long minEnd(int n, int x) {
        long lastNum = x;
        for(long i=1; i<n; i++){
            lastNum++;
            lastNum |= x;
        }
        return lastNum;
    }
}