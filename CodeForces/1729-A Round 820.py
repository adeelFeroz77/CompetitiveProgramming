for t in range(int(input())):
    a,b,c = map(int, input().split())
    first = abs(1-a)
    second = abs(b-c) + abs(1-c)
    if first>second:
        print(2)
    elif first<second:
        print(1)
    else:
        print(3)
