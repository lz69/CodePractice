try:
    f = open('list.py','r')
    print(f.read())
finally:
    if f:
        f.close()

with open('list.py', 'r') as f:
    print(f.read())

try:
    f = open('list.py','r')
    for line in f.readlines():
        print(line.strip())
finally:
    if f:
        f.close()

# try:
#     f = open('sina.html','r', encoding='utf-8', errors='ignore')
#     print(f.read())
# finally:
#     if f:
#         f.close()

try:
    f = open('io.txt','w')
    f.write("hello,io")
finally:
    if f:
        f.close()
