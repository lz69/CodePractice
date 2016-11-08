import pickle

d=dict(name='Bob', age=20, score=88)
print(pickle.dumps(d))

try:
    f = open('dumps.txt', 'wb')
    pickle.dump(d, f)
finally:
    if f:
        f.close()

try:
    f = open('dumps.txt', 'rb')
    d = pickle.load(f)
    print(d)
finally:
    if f:
        f.close()
