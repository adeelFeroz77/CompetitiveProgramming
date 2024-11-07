class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> dict = new HashSet<>();
        int i = 0, j =0;
        int ans = 0;
        while(i<=j && j<n){
            char c = s.charAt(j);
            if(dict.contains(c)){
                while(s.charAt(i) != c){
                    dict.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
            ans = Math.max(j-i+1, ans);
            dict.add(c);
            j++;
        }
        return ans;
    }
}