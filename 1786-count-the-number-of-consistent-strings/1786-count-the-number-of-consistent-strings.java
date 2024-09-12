class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(Character c: allowed.toCharArray()){
            set.add(c);
        }
        int count = 0;
        for(String s: words){
            boolean valid = true;
            for(Character c: s.toCharArray()){
                if(!set.contains(c)){
                    valid = false;
                    break;
                }
            }
            if(valid){
                count++;
            }
        }
        return count;
    }
}