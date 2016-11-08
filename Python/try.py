import logging
try:
    print('try...')
    r = 10/0
    print('result:', r)
except ZeroDivisionError as e:
    logging.exception(e)
    print('except:', e)
finally:
    print('finally...')
print('END')

class FooError(ValueError):
    pass

def foo(s):
    n=int(s)
    if n==0:
        raise FooError('invalid value: %s' % s)
    return 10/n
foo('0')
