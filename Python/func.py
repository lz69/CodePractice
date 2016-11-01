def power(x):
    return x * x
print(power(2))

def power(x, n=2):
    sum = 1;
    while n > 0:
        n = n - 1
        sum = sum * x
    return sum
print(power(5))
n = input("输入要计算2的几次方:")
print(power(2, int(n)))

def say(haha = "haha"):
    print(haha);
say("lala")

def sayName(word1, word2, word3="xing", word4="chang"):
    print(word1, word2, word3, word4)

sayName("zhi", "tian", "cuo")

def calc(*numbers):
    sum = 0
    for n in numbers:
        sum = sum + n * n
    return sum

print(calc(1, 2, 3))

def person(name, age, **kw):
    print('name:', name, 'age:', age, 'other:', kw)

person('zoulilang', '24')
person('zoulilang', '24', city='BeiJing')
