class Solution {
    public int smallestNumber(int n, int t) {
        while(getProduct(n) % t != 0){
            n++;
        }
        return n;
    }

    public static int getProduct(int n){
        int product = 1;
        int x = n;
        while(x>0){
            product *= x%10;
            x/=10;
        }
        return product;
    }
}