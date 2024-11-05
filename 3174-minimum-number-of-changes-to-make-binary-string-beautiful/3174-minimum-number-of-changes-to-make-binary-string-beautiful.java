class Solution {
    public int minChanges(String s) {
        int changes = 0;
        char c = s.charAt(0);
        int i=1;
        while(i<s.length()){
            char x = s.charAt(i);
            if(x != c && i%2!=0){
                changes++;
            }
            c=x;
            i++;
        }
        return changes;
    }
}