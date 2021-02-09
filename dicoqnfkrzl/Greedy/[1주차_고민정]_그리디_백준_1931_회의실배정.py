#!/usr/bin/env python
# coding: utf-8

# In[ ]:


from collections import deque

n = int(input())
timetable = list()

for i in range(n):
    a, b = map(int, input().split())
    timetable.append((a,b))

timetable = sorted(timetable, key=lambda x:(x[1], x[0]))
timetable = deque(timetable)
opening = timetable.popleft()
count = 1

for time in timetable:
    if time[0] >= opening[1]:
        count += 1
        opening = time
print(count)

