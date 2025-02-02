class Solution {
    public String findValidPair(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i=1; i<s.length(); i++){
            char x = s.charAt(i-1);
            char y = s.charAt(i);

            if(x == y){
                continue;
            }

            if(map.get(x) != (x-'0')){
                continue;
            }
            if(map.get(y) != (y - '0')){
                continue;
            }

            return x + "" + y;
        }

        return "";
    }
}