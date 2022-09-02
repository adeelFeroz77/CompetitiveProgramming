n,limit = map(int, input().split())
arr = [[int(s) for s in input().split()] for i in range(n)]
dp = [[0 for j in range(limit+1)]for i in range(n)]

for i in range(n):
    for j in range(1,limit+1):
        if i==0:
            if j>=arr[i][0]:
                dp[i][j] = arr[i][1]
            continue
        take = 0
        notTake = dp[i-1][j]
        if j>=arr[i][0]:
            take = arr[i][1] + dp[i-1][j-arr[i][0]]
        dp[i][j] = max(take,notTake)
print(dp[i][j])
