#!/usr/bin/env python
# coding: utf-8

# In[ ]:


def solution(number, k):
    left_num_count = len(number) - k
    answer = ""
    start = 0
        
    for left_len in range(left_num_count, 0, -1):
        candidate = number[start:] if left_len == 1 else number[start:-(left_len - 1)]
        now_max = "9" if "9" in candidate else max(candidate)
        answer += now_max
        start = number.find(now_max, start) + 1
        
    return answer

