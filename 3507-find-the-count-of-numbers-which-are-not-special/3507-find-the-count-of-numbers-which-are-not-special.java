class Solution {
    public int nonSpecialCount(int l, int r) {
        int [] arr = new int[((int)Math.sqrt(r))+1];
        Arrays.fill(arr,1);
        arr[0] = 0;
        arr[1] = 0;
        //checking all primes till sqrt(r)
        for(int i=2;i*i<arr.length;i++){
            if(arr[i]>=1){
                for(int j=i*i;j<arr.length;j+=i){
                    arr[j] = 0;
                }
            }
        }
        int special =0 ;
        //special if i*i of prime lies in range
        for(int i=2;i<arr.length;i++){
            if(arr[i] == 1){
                int sqr = i*i;
                if(sqr >= l && sqr <=r){
                    special ++;
                }
            }
        }

        return r-l+1-special;
    }
}