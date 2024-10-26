class Solution {
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int maxi = 0;
        int [][] dp = new int[n+1][k+1];
        for(int j=0; j<=n; j++){
            Arrays.fill(dp[j], -1);
        }
        for(int i=0;i<n;i++){
            maxi = Math.max(getMaxScore(n, k, i, stayScore, travelScore, dp), maxi);
        }
        return maxi;
    }

    public int getMaxScore(int n, int k, int currentCity, int [][] stayScore, int[][] travelScore, int [][] dp){
        if(k == 0){
            return 0;
        }
        if(dp[currentCity][k] != -1){
            return dp[currentCity][k];
        }
        int pick = 0, notPick = 0;
        for(int i=0; i<n; i++){
            if(i == currentCity){
                notPick = stayScore[stayScore.length-k][currentCity] + getMaxScore(n, k-1, currentCity, stayScore, travelScore, dp);
            }else{
                pick = Math.max(pick,travelScore[currentCity][i] + getMaxScore(n, k-1, i, stayScore, travelScore, dp));
            }
        }
        dp[currentCity][k] = Math.max(pick, notPick);
        return Math.max(pick, notPick);
    }
}