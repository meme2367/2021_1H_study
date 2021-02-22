#!/usr/bin/env python
# coding: utf-8

# In[ ]:


from collections import deque

def bfs(graph, visited, start):
    que = deque()
    que.append(start)
    visited[start] = True
    answer = 0
    
    while que:
        now = que.popleft()
        for node in graph[now]:
            if not visited[node]:
                que.append(node)
                visited[node] = True
                answer += 1
    return answer

len_node = int(input())
len_edge = int(input())
graph = [[] for _ in range(len_node + 1)]
visited = [False] * (len_node + 1)

for _ in range(len_edge):
    start, target = map(int, input().split())
    graph[start].append(target)
    graph[target].append(start)
    
print(bfs(graph, visited, 1))

