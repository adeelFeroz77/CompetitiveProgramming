class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int idx =0;
        for(int i=0; i<s.length(); i++){
            if(idx < spaces.length && spaces[idx] == i){
                sb.append(" ");
                idx++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}