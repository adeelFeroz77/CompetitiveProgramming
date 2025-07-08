class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a,b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        int [][] dp = new int[n][k+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return solve(0, dp, events, k);
    }

    public int solve(int index, int [][] dp, int[][] events, int k){
        if(index >= events.length || k <= 0){
            return 0;
        }

        if(dp[index][k] != -1){
            return dp[index][k];
        }

        int notTake = solve(index+1, dp, events, k);
        int take = 0;
        int idx = findNextIndex(events[index][1], events);
        take = events[index][2] + solve(idx, dp, events, k-1);

        dp[index][k] = Math.max(notTake, take);
        return dp[index][k];
    }

    public int findNextIndex(int endDay, int[][] events) {
    int left = 0, right = events.length;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (events[mid][0] > endDay) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
}

}