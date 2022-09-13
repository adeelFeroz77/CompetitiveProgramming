for t in range(int(input())):
    n = int(input())
    s = input()
    ptr = n-1
    out = ""
    while(ptr>=0):
        if s[ptr]!='0':
            out = chr(int(s[ptr])+96) + out
            ptr-=1
        else:
            out = chr(int(s[ptr-2:ptr])+96) + out
            ptr-=3
    print(out)
