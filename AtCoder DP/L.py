sys.setrecursionlimit(10**9)

def getVals(start,end,turn,arr,dp):
    if start>end:
        return 0
    if dp[start][end][turn-1]!=-1:
        return dp[start][end][turn-1]
    if turn==1:
        left =  getVals(start+1,end,2,arr,dp) + arr[start]
        right =  getVals(start,end-1,2,arr,dp) + arr[end]
        dp[start][end][turn-1] = max(left,right)
        return max(left,right)
    else:
        left =  getVals(start+1,end,1,arr,dp) - arr[start]
        right = getVals(start,end-1,1,arr,dp) - arr[end]
        dp[start][end][turn-1] = min(left,right) 
        return min(left,right)
    

n = int(input())
dp = [[[0 for i in range(2)]for j in range(n+1)]for k in range(n+1)]
arr = [int(s) for s in input().split()]
# print(getVals(0,n-1,1,arr,dp))
for i in range(n):
    dp[i][i]= [arr[i],arr[i]]


for i in range(n-1,-1,-1):
    for j in range(i,n):
        for k in range(2):
            if k==0:
                left = dp[i+1][j][1] + arr[i]
                right = dp[i][j-1][1] + arr[j]
                dp[i][j][k] = max(left,right)
            else:
                left = dp[i+1][j][0] - arr[i]
                right = dp[i][j-1][0] - arr[j]
                dp[i][j][k] = min(left,right)
print(-dp[i][j][k])
