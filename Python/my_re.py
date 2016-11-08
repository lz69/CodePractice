import re

print(re.match(r'\d{3}\-\d{3,8}$', '010-12345'))
print(re.match(r'^\d{3}\-\d{3,8}$', '010 12345'))

print('a b  c'.split(' '))
print(re.split(r'\s+', 'a b  c'))
print(re.split(r'\s+,', 'a b  c'))
print(re.split(r'\s+;', 'a b  c'))

m = re.match(r'^(\d{3})-(\d{3,8})$', '010-12345')
print(m.group(0))
print(m.group(1))
print(m.group(2))

print(re.match(r'^(\d+)(0*)$', '102300').groups())
print(re.match(r'^(\d+?)(0*)$', '102300').groups())

re_telephone = re.compile(r'^(\d{3})-(\d{3,8})$')
print(re_telephone.match('010-12345').groups())

re_email = re.compile(r'^([\w+\_]+)\@([\w+\_]+.[\w+\_]+)$')
print(re_email.match('leonzou69@gmail.com').groups())
# re_email = re.comile(r'^(<[a-zA-Z\.\s]{1,19}>)\s+(([0-9a-zA-Z\.]{1,19})\@[0-9a-z]{2,9}\.(com|org))$')
# print(re_email.match('<Tom Paris> tom@voyager.org').groups())
