class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        // int [][] preSum = new int[n][];
        // for(int i=0; i<n; i++){
        //     List<Integer> list = piles.get(i);
        //     int m = list.size();
        //     preSum[i] = new int[m];
        //     int sum = 0;
        //     for(int j=0;j<m;j++){
        //         sum+=list.get(j);
        //         preSum[i][j] = sum;
        //     }
        // }
        int [][] dp = new int[n+1][k+1];
        return calculateMax(piles, k, 0, dp);
    }

    public int calculateMax(List<List<Integer>> piles, int k, int idx, int [][] dp){
        if(idx >= piles.size()){
            return 0;
        }
        if(k == 0){
            return 0;
        }
        if(dp[idx][k] != 0){
            return dp[idx][k];
        }
        int n = piles.get(idx).size();
        int pick = 0, notPick = 0;
        int preSum = 0;
        for(int i=0;i<n;i++){
            if(k-i-1 >= 0) {
                preSum += piles.get(idx).get(i);
                pick = Math.max(preSum + calculateMax(piles, k-i-1, idx+1, dp), pick);
            }
            notPick = Math.max(calculateMax(piles, k, idx+1, dp), notPick);
        }
        dp[idx][k] = Math.max(pick, notPick);
        return Math.max(pick, notPick);
    }
}