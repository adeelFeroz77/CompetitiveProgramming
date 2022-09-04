import sys
sys.setrecursionlimit(10**9)


n,m = map(int, input().split())
adj = [[]for i in range(n+1)]
for i in range(m):
    ver,edg = map(int,input().split())
    adj[ver].append(edg)
visited = [0]*(n+1)
dp = [0]*(n+1)

def dfs(node,dp):
    if visited[node]==1:
        return dp[node]
    cost = 0
    for i in adj[node]:
        if visited[i]==0:
            cost = max(cost,1 + dfs(i,dp))
            visited[i] = 1
        else:
            cost = max(cost,1+dp[i])
    dp[node] = cost
    return dp[node]

for i in range(1,n+1):
    dfs(i,dp)
print(max(dp))
