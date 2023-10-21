class Solution {
    public int findKthPositive(int[] arr, int k) {
        int pos = 1;
        int num = 1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=num){
                if(pos==k){
                    return num;
                }else{
                    num++;
                    pos++;
                    i--;
                }
            }else{
                num++;
            }
        }
        if(pos==k){
            return num;
        }
        return num+k-pos;
    }
}