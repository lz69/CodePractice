def calc_sum(*args):
    ax = 0
    for n in args:
        ax = ax + n
    return ax
print(calc_sum(1,2,3,4,5,5,7))

def lazy_sum(*args):
    def sum():
        ax = 0
        for n in args:
            ax = ax + n
        return ax
    return sum
f = lazy_sum(1,2,3,4)
print(f())

def build(x, y):
    return lambda: x * y
f = build(3, 4)
print(f())
