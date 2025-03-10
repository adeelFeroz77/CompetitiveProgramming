class Solution {
    public long countOfSubstrings(String word, int k) {
        int n = word.length();

        int [] nextCons = new int[n];
        int lastCons = n;
        for(int i=n-1; i>=0; i--){
            nextCons[i] = lastCons;
            if(!isVowel(word.charAt(i))){
                lastCons = i;
            }
        }

        Map<Character, Integer> map = new HashMap<>();
        int cons = 0;

        int i = 0, j = 0;
        long ans = 0;

        while(j<n){
            char c = word.charAt(j);
            if(isVowel(c)){
                map.put(c, map.getOrDefault(c, 0) +1);
            }else{
                cons ++;
            }

            while(i<n && cons > k){
                char cx = word.charAt(i);
                if(isVowel(cx)){
                    int cnt = map.getOrDefault(cx, 0);
                    if(cnt <= 1){
                        map.remove(cx);
                    }else{
                        map.put(cx, cnt-1);
                    }
                }else{
                    cons--;
                }
                i++;
            }

            while(i<n && map.size()==5 && cons == k){
                int next = nextCons[j];
                char cx = word.charAt(i);
                ans += next-j;

                if(isVowel(cx)){
                    int cnt = map.getOrDefault(cx, 0);
                    if(cnt <= 1){
                        map.remove(cx);
                    }else{
                        map.put(cx, cnt-1);
                    }
                }else{
                    cons--;
                }
                i++;
            }
            j++;
        }
        return ans;
    }

    public boolean isVowel(char c){ 
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}