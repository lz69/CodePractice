def fact(n):
    if(n==1):
        return 1;
    return n * fact(n - 1)

print(fact(200))

def move(n,a,buffer,c):
    w='The End'
    if n==1:
        print(a, '-->', c)
    else:
        move(n-1, a, c, buffer)
        move(1, a, buffer, c)
        move(n-1, buffer, a, c)
    return w
n=int(input('请输入汉诺塔的层数:'))
print(move(n,'起始柱','临时柱','目标柱'))
