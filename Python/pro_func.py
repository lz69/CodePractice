f = abs
print(f(-10))

def add(x, y, f):
    return f(x) + f(y)
print(add(-10, -5, abs))
