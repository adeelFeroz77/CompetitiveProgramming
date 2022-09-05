import sys
sys.stdin = open('CP/Input.txt','r')
sys.stdout = open('CP/Output.txt','w')

for t in range(int(input())):
    r,c = map(int, input().split())
    arr = [[s for s in input()]for i in range(r)]
    trees = []
    for i in range(r):
        for j in range(c):
            if arr[i][j] == '^':
                trees.append([i,j])
    i = 0
    ans = "Possible"
    while(i<len(trees)):
        current = trees[i]
        x,y = current[0],current[1]
        adjCount = 0
        #UP
        if (x-1>=0) and (arr[x-1][y])=='^':
            adjCount+=1
        #DOWN
        if (x+1<r) and (arr[x+1][y])=='^':
            adjCount+=1
        #LEFT
        if (y-1>=0) and (arr[x][y-1])=='^':
            adjCount+=1
        #RIGHT
        if (y+1<c) and (arr[x][y+1])=='^':
            adjCount+=1
        if adjCount<2:
            #UP
            if (x-1>=0) and (arr[x-1][y])!='^':
                adjCount+=1
                arr[x-1][y]='^'
                trees.append([x-1,y])
            #DOWN
            if (x+1<r) and (arr[x+1][y])!='^' and adjCount<2:
                adjCount+=1
                arr[x+1][y]='^'
                trees.append([x+1,y])
            #LEFT
            if (y-1>=0) and (arr[x][y-1])!='^' and adjCount<2:
                adjCount+=1
                arr[x][y-1]='^'
                trees.append([x,y-1])
            #RIGHT
            if (y+1<c) and (arr[x][y+1])!='^' and adjCount<2:
                adjCount+=1
                arr[x][y+1]='^'
                trees.append([x,y+1])
        if adjCount<2:
            ans="Impossible"
            break
        i+=1
    print(f"Case #{t+1}: {ans}")
    if ans=='Possible':
        for i in range(r):
            for j in range(c):
                print(arr[i][j] , end='')
            print()

