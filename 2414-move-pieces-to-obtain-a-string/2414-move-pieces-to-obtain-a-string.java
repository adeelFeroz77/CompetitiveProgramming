class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int m = target.length();
        int i = 0, j = 0;
        while(i < n && j <m){
            if(start.charAt(i) == '_'){
                i++;
                continue;
            }
            if(target.charAt(j) == '_'){
                j++;
                continue;
            }
            if(start.charAt(i) != target.charAt(j)){
                return false;
            }
            if((start.charAt(i) == 'L' && i<j) || (start.charAt(i) == 'R' && i>j)){
                return false;
            }
            i++;
            j++;
        }
        while(i<n && start.charAt(i) == '_'){
            i++;
        }
        while(j<n && target.charAt(j) == '_'){
            j++;
        }
        return i==j && i == n;

    }
}