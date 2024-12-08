class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        int[][] dp = new int[events.length][3];
        for (int[] d: dp)
            Arrays.fill(d, -1);
        return solve(0, 0, events, dp);
    }

    public static int solve(int index, int k, int [][] events, int [][] dp){
        if(index >= events.length){
            return 0;
        }
        if(k == 2){
            return 0;
        }
        if(dp[index][k] != -1){
            return dp[index][k];
        }
        int endTime = events[index][1];

        int left = index+1, right = events.length-1;
        while(left < right){
            int mid = (left + right) /2 ;
            if(events[mid][0] > endTime){
                right = mid;
            }else{
                left = mid +1;
            }
        }

        int pick = events[index][2] + (left < events.length && events[left][0] > endTime ? solve(left, k+1, events, dp) : 0);

        int notPick = solve(index+1, k, events, dp);

        dp[index][k] = Math.max(pick, notPick);
        return dp[index][k];
    }
}