class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int len = n+m;
        int sum = 0;
        for(int i=0;i<m;i++){
            sum += rolls[i];
        }
        int missing = (len * mean)-sum;
        if(missing < n || missing > 6*n){
            return new int[0];
        }
        int [] ans = new int[n];
        int div = missing/n;
        for(int i=0;i<n;i++){
            ans[i] = div;
        }
        int rem = missing%n;
        for(int i=0;i<rem;i++){
            ans[i]++;
        }
        return ans;
    }
}