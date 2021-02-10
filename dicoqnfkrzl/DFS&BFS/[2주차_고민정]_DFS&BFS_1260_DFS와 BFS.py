#!/usr/bin/env python
# coding: utf-8

# In[ ]:


from collections import deque

def dfs(graph, visited, start):
    visited[start] = True
    print(start, end = " ")
    
    for node in graph[start]:
        if not visited[node]:
            dfs(graph, visited, node)
            
def bfs(graph, visited, start):
    que = deque()
    que.append(start)
    visited[start] = True
    
    while que:
        now = que.popleft()
        print(now, end = " ")
        for node in graph[now]:
            if not visited[node]:
                que.append(node)
                visited[node] = True

n, m, v = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    start, target = map(int, input().split())
    graph[start].append(target)
    graph[target].append(start)
graph = list(map(lambda node: sorted(node), graph))
    
dfs(graph, [False] * (n+1), v)
print()
bfs(graph, [False] * (n+1), v)   

