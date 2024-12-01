class Solution {
    public boolean checkIfExist(int[] arr) {
        //optimized approach using HashSet
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            int num = arr[i];
            if(set.contains(num*2) || (num%2==0 && set.contains(num/2))){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}