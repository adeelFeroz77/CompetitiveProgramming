n = int(input())
vals = [int(s) for s in input().split()]
cost = [10e9 for i in range(n)]
cost[0] = 0
cost[1] = abs(vals[1]-vals[0])
for i in range(2,n):
    cost[i] = min(abs(vals[i]-vals[i-1])+cost[i-1],abs(vals[i]-vals[i-2])+cost[i-2])
print(cost[n-1])
