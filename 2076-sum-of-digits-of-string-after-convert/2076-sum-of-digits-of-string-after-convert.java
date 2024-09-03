class Solution {
    public int getLucky(String s, int k) {
        String val = "";
        for(char c: s.toCharArray()){
            val += c - 'a' +1;
        }
        int count = 0;
        while(count<k){
            int sum = 0;
            for(char c: val.toCharArray()){
                sum += c-'0';
            }
            val = String.valueOf(sum);
            count++;
        }
        return Integer.parseInt(val);
    }
}