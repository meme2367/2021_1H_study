#!/usr/bin/env python
# coding: utf-8

# In[12]:


n = int(input())
lengths = list(map(int, input().split()))
prices = list(map(int, input().split()))

from collections import deque

answer = 0
min_oil_price = prices[0]
prices = deque(prices)

for length in lengths:
    now_oil_price = prices.popleft()
    min_oil_price = min(min_oil_price, now_oil_price)
    answer += length * min_oil_price

answer


# In[ ]:




