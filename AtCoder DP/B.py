n,k = map(int, input().split())
vals = [int(s) for s in input().split()]
dp = [float("inf") for i in range(n)]
dp[0] = 0
for i in range(n):
    for j in range(1,k+1):
        if i-j>=0:
            dp[i] = min(dp[i],abs(vals[i]-vals[i-j])+dp[i-j])
print(dp[n-1])

