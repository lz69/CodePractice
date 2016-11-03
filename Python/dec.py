def now():
    print("2016-11-03")
f = now
print(f())
print(f.__name__)

def log(func):
    def wrapper():
        print('call %s():' %func.__name__ )
        return func()
    return wrapper

@log
def now():
    print("2016-11-03")
now()
