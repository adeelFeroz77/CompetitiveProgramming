class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        Arrays.sort(items, (a,b) -> Integer.compare(a[0], b[0]));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(items[0][0], items[0][1]);
        int last = items[0][1];
        for(int i=1; i<n; i++){
            int key = items[i][0];
            int val = items[i][1];
            if(last > val){
                continue;
            }else{
                map.put(key,val);
                last = val;
            }
        }
        int [] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            Integer key = map.floorKey(queries[i]);
            if(key == null){
                ans[i] = 0;
            }else{
                ans[i] = map.get(key);
            }
        }
        return ans;
    }
}