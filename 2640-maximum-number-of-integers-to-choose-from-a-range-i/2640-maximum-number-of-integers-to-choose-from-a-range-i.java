class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean [] bans = new boolean[10001];
        for(int i=0; i<banned.length; i++){
            bans[banned[i]] = true;
        }
        int sum =0;
        int nums = 0;
        for(int i=1; i<=n; i++){
            if(bans[i]){
                continue;
            }
            if(sum + i > maxSum){
                break;
            }
            sum += i;
            nums++;
        }
        return nums;
    }
}