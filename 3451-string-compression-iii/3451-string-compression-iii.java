class Solution {
    public String compressedString(String word) {
        int n = word.length();
        char prev = word.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n;i ++){
            char c = word.charAt(i);
            if(c == prev && count < 9){
                count++;
                continue;
            }
            sb.append(count).append(prev);
            prev = c;
            count = 1;
        }
        sb.append(count).append(prev);
        return sb.toString();
    }
}