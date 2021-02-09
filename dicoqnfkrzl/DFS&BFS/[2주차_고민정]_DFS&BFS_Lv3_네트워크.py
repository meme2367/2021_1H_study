#!/usr/bin/env python
# coding: utf-8

# - 정답

# In[ ]:


from collections import deque

def bfs(start, visited, computers):
    que = deque()
    que.append(start)
    
    while que:
        now = que.popleft()
        visited[now] = True
        for idx, computer in enumerate(computers[now]):
            if not visited[idx] and computer == 1:
                que.append(idx)

def solution(n, computers):
    visited = [False] * n
    answer = 0
    
    for idx in range(n):
        if not visited[idx]:
            answer += 1
            bfs(idx, visited, computers)
            
    return answer


# - 디버깅용

# In[ ]:


from collections import deque

def bfs(start, visited, computers):
    que = deque()
    que.append(start)
    
    while que:
        now = que.popleft()
        visited[now] = True
        for idx, computer in enumerate(computers[now]):
            if not visited[idx] and computer == 1:
                que.append(idx)
        print(now, que, visited)


# In[15]:


n = 3
computers = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]

visited = [False] * n
answer = 0

for idx in range(n):
    if not visited[idx]:
        print(idx, computer)
        answer += 1
        bfs(idx, visited, computers)
        print(answer, visited)
        
answer

