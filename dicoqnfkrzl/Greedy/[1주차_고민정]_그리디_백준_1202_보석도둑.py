#!/usr/bin/env python
# coding: utf-8

# In[ ]:


import sys
import heapq
from collections import deque


n, k = map(int, input().split())
gems = []
for _ in range(n):
    weight, value = map(int, sys.stdin.readline().split())
    gems.append((weight, value))
bag_max_weights = [int(sys.stdin.readline()) for _ in range(k)]

bag_max_weights.sort()
WEIGHT, VALUE = 0, 1
gems.sort(key=lambda x: x[WEIGHT])
gems = deque(gems)

candidates = []
answer = 0
for bag_weight in bag_max_weights:
    while gems and gems[0][WEIGHT] <= bag_weight:
        gem = gems.popleft()
        heapq.heappush(candidates, (-gem[VALUE]))
        
    if candidates:
        answer += heapq.heappop(candidates)
        
print(-answer)


# 백준의 input으로 인해 시간초과가 날 경우
# import sys
# input() > sys.stdin.readline() 로 바꾼다.

# In[ ]:


n, k = map(int, input().split())
gems = []
for _ in range(n):
    weight, value = map(int, input().split())
    gems.append((weight, value))
bag_max_weights = [int(input()) for _ in range(k)]


# In[ ]:


import sys

n, k = map(int, input().split())
gems = []
for _ in range(n):
    weight, value = map(int, sys.stdin.readline().split())
    gems.append((weight, value))
bag_max_weights = [int(sys.stdin.readline()) for _ in range(k)]

