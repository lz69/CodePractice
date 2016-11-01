import os

print([d for d in os.listdir('.')])

L1 = ['Hello', 'World', 18, 'Apple', None]
L2 = [d.lower() for d in L1 if isinstance(d, str)]
print(L2);

T1 = (x*x for x in range(5))
for t in T1:
    print(t)
