class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        int m = spaces.length;
        char [] arr = new char[n+m];

        for(int i=0, j=0; i<n; i++){
            if(j<m && spaces[j]+j == i+j){
                arr[i+j] = ' ';
                j++;
            }
            arr[i+j] = s.charAt(i);
        }
        
        return new String(arr);
    }
}