class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(nums1[i][0]);
        }
        for(int i=0; i<m; i++){
            set.add(nums2[i][0]);
        }

        int [][] ans = new int[set.size()][2];

        int i =0, j=0;
        int k = 0;
        while(i<n && j<m){
            int key1 = nums1[i][0];
            int key2 = nums2[j][0];

            if(key1 < key2){
                ans[k][0] = key1;
                ans[k][1] = nums1[i][1];
                k++;
                i++;
            }
            else if(key1 > key2){
                ans[k][0] = key2;
                ans[k][1] = nums2[j][1];
                k++;
                j++;
            }
            else{
                ans[k][0] = key1;
                ans[k][1] = nums1[i][1] + nums2[j][1];
                k++;
                i++;
                j++;
            }
        }

        while(i<n){
            ans[k][0] = nums1[i][0];
            ans[k][1] = nums1[i][1];
            k++;
            i++;
        }

        while(j<m){
            ans[k][0] = nums2[j][0];
            ans[k][1] = nums2[j][1];
            k++;
            j++;
        }

        return ans;
    }
}