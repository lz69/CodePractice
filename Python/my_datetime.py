import re
from datetime import datetime, timedelta, timezone

now = datetime.now()
print(now)

dt = datetime(1992, 6, 9, 15, 33, 59)
print(dt)
tt = dt.timestamp()
print(tt)
print(datetime.fromtimestamp(tt))

cday = datetime.strptime('2015-6-1 18:19:59', '%Y-%m-%d %H:%M:%S')
print(cday)

now = datetime.now()
print(now)
print(now + timedelta(days=1, hours=-10))
