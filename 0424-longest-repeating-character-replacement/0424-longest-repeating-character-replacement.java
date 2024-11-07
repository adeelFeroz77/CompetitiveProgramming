class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int ans = 0;
        for(char c = 'A'; c<= 'Z'; c++){
            int i = 0, j = 0;
            int limit = k;
            while(i<=j && j<n){
                char x = s.charAt(j);
                if(x != c){
                    if(limit > 0){
                        limit--;
                    }else{
                        while(s.charAt(i) == c){
                            i++;
                        }
                        i++;
                        // limit++;
                    }
                }
                ans = Math.max(ans, j-i+1);
                j++;
            }
        }
        return ans;
    }
}