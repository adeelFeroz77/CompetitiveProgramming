class Solution {
    public boolean isCircularSentence(String sentence) {
        // sentence = sentence.toLowerCase();
        int n = sentence.length();
        String [] arr = sentence.split(" ");
        for(int i=1;i<arr.length;i++){
            if(arr[i].charAt(0) != arr[i-1].charAt(arr[i-1].length()-1)){
                return false;
            }
        }
        return sentence.charAt(0) == sentence.charAt(n-1);
    }
}