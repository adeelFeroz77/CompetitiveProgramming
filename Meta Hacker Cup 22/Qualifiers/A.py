import sys
sys.stdin = open('CP/Input.txt','r')
sys.stdout = open('CP/Output.txt','w')

for t in range(int(input())):
    n,k = map(int, input().split())
    vals = [int(s) for s in input().split()]
    vals.sort()
    ans = "YES"
    samecount= 0
    if len(vals)>k*2:
        ans="NO"
    else:
        for i in range(1,n):
            if vals[i]==vals[i-1]:
                samecount+=1
            else:
                samecount = 0
            if samecount>=2:
                ans="NO"
                break
    print(f"Case #{t+1}: {ans}")

