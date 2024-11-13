class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int i= 0, j = 0;
        int [] s1Map = new int[26];
        int [] s2Map = new int[26];
        for(char c: s1.toCharArray()){
            s1Map[c-'a']++;
        }
        while(j<s2.length()){
            char c = s2.charAt(j);
            if(s1Map[c-'a'] > 0){
                s2Map[c-'a']++;
                if(checkMaps(s1Map, s2Map)){
                    return true;
                }
                if(s2Map[c-'a'] > s1Map[c-'a']){
                    while(s2Map[c-'a'] > s1Map[c-'a']){
                        s2Map[s2.charAt(i)-'a']--;
                        i++;
                        if(checkMaps(s1Map, s2Map)){
                            return true;
                        }
                    }
                    // i++;
                }
            }else{
                s2Map = new int[26];
                i = j+1;
            }
            j++;
        }
        return false;
    }

    public static boolean checkMaps(int [] m1, int [] m2){
        for(int i=0; i<26; i++){
            if(m1[i] != m2[i]){
                return false;
            }
        }
        return true;
    }
}