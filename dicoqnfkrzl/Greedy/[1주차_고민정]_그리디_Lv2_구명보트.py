#!/usr/bin/env python
# coding: utf-8

# In[14]:


from collections import deque

def solution(people, limit):
    people = deque(sorted(people))
    in_boat = 0
    answer = 0
    while people:
        if len(people) >= 2 and people[0] + people[-1] <= limit:
            people.pop()
            people.popleft()
        else:
            people.pop()
        answer += 1
        in_boat = 0
        
    return answer

