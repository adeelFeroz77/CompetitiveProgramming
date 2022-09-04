n = int(input())
arr = [float(s) for s in input().split()]
tailLimit = n//2
dp = [[1 for j in range(tailLimit+2)]for i in range(n+1)]
# print(getProb(n-1,tailLimit,arr,dp))

for i in range(1,n+1):
    for j in range(1,tailLimit+2):
        notTail = arr[i-1] *dp[i-1][j]
        tail = 0
        if j>1:
            tail = (1-arr[i-1])*dp[i-1][j-1]
        dp[i][j] = notTail + tail
print(dp[i][j])
