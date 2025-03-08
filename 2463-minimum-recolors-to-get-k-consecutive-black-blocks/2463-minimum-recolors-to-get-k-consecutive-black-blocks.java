class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int i =0, j =0;
        int white = 0;
        int black = 0;
        int mini = 1000000007;
        while(i<=j && j<n){
            if(blocks.charAt(j) == 'W'){
                white++;
            }else{
                black++;
            }

            if(j-i+1 >= k){
                if(j-i+1>k){
                    if(blocks.charAt(i) == 'W'){
                        white--;
                    }else{
                        black--;
                    }
                    i++;
                }
                mini = Math.min(white, mini);
            }
            // System.out.println(j + " " + i + " -> " + mini);
            j++;
        }
        return Math.max(mini,0);
    }
}