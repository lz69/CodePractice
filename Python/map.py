def f(x):
    return x*x
r = map(f, [i for i in range(1, 10)])
print(list(r))

from functools import reduce
def add(x, y):
    return x + y
print(reduce(add, [i for i in range(1, 10)]))

def fn(x, y):
    return x * 10 + y
def char2num(s):
    return {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}[s]
print(reduce(lambda x, y : x * 10 + y, map(char2num, ['1', '3', '5', '7', '9'])))

def normalize(name):
    return name[0].upper() + name[1:].lower()
L1 = ['adam', 'LISA', 'barT']
L2 = list(map(normalize, L1))
print(L2)

def prod(L):
    return reduce(lambda x, y : x * y, L)
print('3 * 5 * 7 * 9 =', prod([3, 5, 7, 9]))

def str2float(s):
    s1 = s.split(".")[0]
    s2 = s.split(".")[1]
    def char2num(s):
        return {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}[s]
    def str2float1(x, y):
        return x * 10 + y
    def str2float2(x, y):
        return x /10 + y
    return reduce(str2float1, map(char2num, s1)) + float(reduce(str2float2, map(char2num, s2[::-1])) / 10)
print('str2float(\'123.456\') =', str2float('123.456'))
