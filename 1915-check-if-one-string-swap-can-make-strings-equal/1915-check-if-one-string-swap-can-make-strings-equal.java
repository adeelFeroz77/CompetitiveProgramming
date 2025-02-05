class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int u = -1;
        int v = -1;

        boolean isReplaced = false;
        for(int i=0; i<n; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(isReplaced){
                    return false;
                }

                if (u == -1){
                    u = s1.charAt(i) - '0';
                    v = s2.charAt(i) - '0';
                }else{
                    if(v != s1.charAt(i)-'0' || u != s2.charAt(i)-'0'){
                        return false;
                    }
                    isReplaced = true;
                }
            }
        }
        if(u != -1 && !isReplaced){
            return false;
        }

        return true;
    }
}