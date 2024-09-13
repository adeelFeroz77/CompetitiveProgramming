class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int [] ans = new int[queries.length];
        int [] pre = new int[arr.length];
        pre[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            pre[i] = pre[i-1]^arr[i];
        }
        for(int i=0;i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            if(left == 0){
                ans[i] = pre[right];
                continue;
            }
            ans[i] = pre[left-1] ^ pre[right];
        }
        return ans;
    }
}