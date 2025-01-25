class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int [][] arr = new int [n][2];
        int [] result = new int[n];

        List<List<Integer>> indices = new ArrayList<>();

        for (int i=0; i<n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));

        for(int i=0; i<n; i++){
            if(i == 0 || arr[i][0] - arr[i-1][0] > limit){
                indices.add(new ArrayList<>());
            }
            indices.get(indices.size()-1).add(arr[i][1]);
        }

        for(List<Integer> index: indices){
            List<Integer> sortedIndex = new ArrayList<>(index);
            Collections.sort(sortedIndex);
            for(int j=0; j<index.size(); j++){
                result[sortedIndex.get(j)] = nums[index.get(j)];
            }
        }
        return result;
    }
}