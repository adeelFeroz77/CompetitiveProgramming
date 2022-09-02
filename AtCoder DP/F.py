s1 = input()
s2 = input()
len1 = len(s1)
len2 = len(s2)
dp=[[0 for j in range(len2+1)]for i in range(len1+1)]

for i in range(1,len1+1):
    for j in range(1,len2+1):
        take = left = right = 0
        if s1[i-1]==s2[j-1]:
            take = 1 + dp[i-1][j-1]
        left = dp[i-1][j]
        right = dp[i][j-1]
        dp[i][j] = max(take,left,right)
i = len1
j = len2
ans = ""
while(i>0 and j>0):
    if s1[i-1]==s2[j-1]:
        ans = s1[i-1]  + ans
        i-=1
        j-=1
    else:
        if dp[i-1][j]>dp[i][j-1]:
            i-=1
        else:
            j-=1
print(ans)
