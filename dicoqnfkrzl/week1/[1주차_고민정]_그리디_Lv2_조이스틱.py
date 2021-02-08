#!/usr/bin/env python
# coding: utf-8

# In[ ]:


def solution(name):
    m = [min(ord(alphabat)-65, 91-ord(alphabat)) for alphabat in name]
    answer = 0
    now = 0
    
    while True:
        answer += m[now]
        m[now] = 0
        
        if sum(m) == 0:
            break
        
        left, right = 1, 1
        
        while m[now-left] == 0:
            left += 1
        while m[now+right] == 0:
            right += 1
            
        answer += min(left, right)
        now += -left if left <= right else right
        
    return answer

