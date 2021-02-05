#!/usr/bin/env python
# coding: utf-8

# In[ ]:


def solution(routes):
    START, END = 0, 1
    routes.sort()
    answer = 1
    candidate = routes[0]

    for route in routes:
        if route[START] > candidate[END]:
            answer += 1
            candidate[START] = route[START]
            candidate[END] = route[END]
            continue
        candidate[START] = route[START]
        candidate[END] = min(candidate[END], route[END])
    return answer

