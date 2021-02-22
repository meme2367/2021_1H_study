#!/usr/bin/env python
# coding: utf-8

# In[10]:


from collections import deque

def check_diff(preword, nextword):
    count_diff = 0
    for pre_letter, next_letter in zip(preword, nextword):
        if pre_letter != next_letter:
            if count_diff == 0:
                count_diff += 1
            else:
                return False
    return True
        

def bfs(begin, target, visited, words):
    que = deque()
    que.append((0, begin))
    
    while que:
        stage, now = que.popleft()
        for idx, word in enumerate(words):
            if not visited[idx] and check_diff(now, word):
                if word == target:
                    return stage + 1
                que.append((stage + 1, word))
                visited[idx] = True
                
    return 0

def solution(begin, target, words):
    words = set(words)
    visited = [False] * len(words)

    if target not in words:
        return 0
    
    
    return bfs(begin, target, visited, words)

