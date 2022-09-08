n,k = map(int, input().split())
arr = [int(s) for s in input().split()]
dp = [0 for i in range(k+1)]
for i in range(1,k+1):
    for j in arr:
        if i>=j and dp[i-j]==0:
            dp[i] = 1
            break
if dp[k]==1:
    print("First")
else:
    print("Second")
