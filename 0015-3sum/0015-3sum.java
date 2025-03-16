class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> n = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            Set<Integer> index = new HashSet<>();
            for(int j=i+1; j<nums.length;j++){
                int x = nums[i]+nums[j];
                int req = -x;
                if(index.contains(req)){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(req);
                    Collections.sort(l);
                    n.add(l);
                }
                index.add(nums[j]);
            }
        }
        return new ArrayList<>(n);
    }
}