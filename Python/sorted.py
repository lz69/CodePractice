print(sorted([36, 5, -12, 9, -21]))

print(sorted([36, 5, -12, 9, -21], key=abs))


L = [('Bob', 75), ('Adam', 92), ('Bart', 66), ('Lisa', 88)]

def by_name(t):
    return t[0].lower()
def by_score(t):
    return t[1]
print(sorted(L, key=by_name))
print(sorted(L, key=by_score, reverse=True))
