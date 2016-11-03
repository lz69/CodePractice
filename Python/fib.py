def fib(max):
    n , a, b = 0, 0, 1
    while(n < max):
        print(b)
        a, b = b, a + b
        n=n+1
fib(10)

def odd():
    print("step 1")
    yield 1
    print("step 2")
    yield 2
    print("step 3")
    yield 3
o = odd()
next(o)
next(o)
next(o)

def gen_fib(max):
    n , a, b = 0, 0, 1
    while(n < max):
        print(b)
        a, b = b, a + b
        n=n+1
        yield a

g = gen_fib(10)
next(g)
next(g)
next(g)
next(g)
next(g)
next(g)

def triangles():
    L = [1]
    while True:
        yield L
        L = [1] + [L[i] + L[i+1] for i in range (len(L) - 1)] + [1]


n = 0
for t in triangles():
    print(t)
    n = n + 1
    if n == 10:
        break
