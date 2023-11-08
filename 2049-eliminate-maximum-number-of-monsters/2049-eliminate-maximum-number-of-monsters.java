class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int [] limit = new int[n];
        for(int i=0;i<n;i++){
            limit[i] = dist[i]/speed[i] + ((dist[i]%speed[i]>=1)?1:0);
        }
        Arrays.sort(limit);
        //System.out.println(Arrays.toString(limit));
        int ans = 1;
        for(int i=1;i<n;i++){
            if(i>=limit[i]){
                break;
            }
            ans++;
        }
        return ans;
    }
}
