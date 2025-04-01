class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long [] dp = new long[n];
        Arrays.fill(dp, -1);

        solve(0, questions, dp);

        long maxi = 0;
        for(int i=0; i<n; i++){
            maxi = Math.max(dp[i], maxi);
        }

        return maxi;
    }

    public long solve(int index, int [][] questions, long [] dp){
        if(index >= questions.length){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        long notTake = solve(index+1, questions, dp);
        long take = questions[index][0] + solve(index + questions[index][1] +1, questions, dp);

        dp[index] = Math.max(notTake, take);
        return dp[index];
    }
}