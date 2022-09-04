
n,m = map(int,input().split())
arr = [[int(0) if s=="." else int(-1) for s in input()]for i in range(n)]
mod = 10**9+7
dp = [[0 for j in range(m)]for i in range(n)]
dp[0][0]=1
for i in range(1,m):
    if arr[0][i]!=-1:
        dp[0][i] = dp[0][i-1]
for i in range(1,n):
    if arr[i][0]!=-1:
        dp[i][0] = dp[i-1][0]

for i in range(1,n):
    for j in range(1,m):
        if arr[i][j]!=-1:
            dp[i][j] = ((dp[i-1][j])%mod+(dp[i][j-1])%mod)%mod
print(dp[i][j])
