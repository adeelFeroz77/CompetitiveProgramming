class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        int oneCount = 0;
        
        for(int i=0; i<n; i++) {
            int currentGcd = nums[i];
            if(nums[i] == 1){
                oneCount++;
            }
            for(int j=i; j<n; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if(currentGcd == 1){
                    ans = Math.min(ans, j-i+(n-1));
                }
            }
        }

        if(oneCount > 0){
            return n - oneCount;
        }


        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    public static int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}