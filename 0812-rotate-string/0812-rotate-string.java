class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        String x = s + s;
        return x.contains(goal);
    }
}