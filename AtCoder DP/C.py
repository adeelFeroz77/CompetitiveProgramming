n = int(input())
arr = [[int(s) for s in input().split()]for i in range(n)]
dp = [[0 for j in range(3)]for i in range(n)]

for i in range(n):
    for j in range(3):
        if i==0:
            if j==0:
                dp[i][j] = max(arr[i][j+1],arr[i][j+2])
            elif j==1:
                dp[i][j] = max(arr[i][j-1],arr[i][j+1])
            else:
                dp[i][j] = max(arr[i][j-1],arr[i][j-2])
        else:
            first = second = third = 0
            if j!=0:
                first = arr[i][j] + dp[i-1][0]
            if j!=1:
                second = arr[i][j] + dp[i-1][1]
            if j!=2:
                third = arr[i][j] + dp[i-1][2]
            dp[i][j] = max(first,second,third)
print(max(dp[i]))
