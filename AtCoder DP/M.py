n,k = map(int,input().split())
arr = [int(s) for s in input().split()]
dp = [[0 for j in range(k+1)]for i in range(n+1)]
mod = 10**9+7

dp[0][0] = 1
for i in range(n+1):
    dp[i][0] = 1
j=0
for i in range(1,n+1):
    prefixSum = [0 for j in range(k+1)]
    prefixSum[0] = dp[i-1][0]
    for j in range(1,k+1):
        prefixSum[j] = (prefixSum[j-1] + dp[i-1][j])%mod
    for j in range(1,k+1):
        if j<=arr[i-1]:
            dp[i][j] = prefixSum[j]%mod
        else:
            dp[i][j] = (prefixSum[j] - prefixSum[j-arr[i-1]-1]+mod)%mod
print(dp[i][j])
