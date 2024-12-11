class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            map.put(n+k+1, map.getOrDefault(n+k+1,0)-1);
            map.put(n-k, map.getOrDefault(n-k,0)+1);
        }
        int ans =0, last = 0;
        for(int key: map.keySet()){
            // System.out.println(key + "-> " + map.get(key));
            last += map.get(key);
            ans = Math.max(ans, last);
        }
        return ans;
    }
}