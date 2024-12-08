class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int[][] dp = new int[events.length][3];
        for (int[] d: dp)
            Arrays.fill(d, -1);
        return dfs(events, 0, 0, dp);
    }
    int dfs(int[][] events, int idx, int cnt, int[][] dp) {
        if (cnt == 2 || idx >= events.length)
            return 0;
        if (dp[idx][cnt] == -1) {
            int end = events[idx][1];
            int lo = idx + 1, hi = events.length - 1;
            while (lo < hi) {
                int mid = lo + ((hi - lo)>>1);
                if (events[mid][0] > end)
                    hi = mid;
                else
                    lo = mid + 1;
            }
            int include = events[idx][2] + (lo < events.length && events[lo][0] > end ? dfs(events, lo, cnt + 1, dp) : 0);
            int exclude = dfs(events, idx + 1, cnt, dp);
            dp[idx][cnt] = Math.max(include, exclude);
        }
        return dp[idx][cnt];
    }
}