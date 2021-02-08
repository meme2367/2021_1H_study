#!/usr/bin/env python
# coding: utf-8

# In[ ]:


n, k = map(int, input().split())
values = list()
for i in range(n):
    values.append(int(input()))

values = reversed(values)
count = 0
for i in values:
    if k >= i:
        count += k//i
        k = k%i
print(count)

