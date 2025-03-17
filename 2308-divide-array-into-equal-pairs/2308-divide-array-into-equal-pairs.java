class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0 ) + 1);
        }

        for(Integer key: map.keySet()){
            if(map.get(key) % 2 != 0){
                return false;
            }
        }
        return true;
    }
}