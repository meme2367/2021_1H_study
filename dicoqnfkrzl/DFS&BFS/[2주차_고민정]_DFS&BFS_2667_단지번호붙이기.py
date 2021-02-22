#!/usr/bin/env python
# coding: utf-8

# In[ ]:


n = int(input())
maps = list(list(map(int, input())) for i in range(n))

from collections import deque

def bfs(graph, visited, n, i, j, dx, dy, seq):
    que = deque([(i, j)])
    visited[i][j] = True
    graph[i][j] = seq
    
    while que:
        v = que.popleft()
        i = v[0]
        j = v[1]
        
        for p in range(len(dx)):
            ni = i + dx[p]
            nj = j + dy[p]
            if 0 <= ni < n and 0 <= nj < n:
                if graph[ni][nj] == 1 and not visited[ni][nj]:
                    visited[ni][nj] = True
                    que.append((ni, nj))
                    graph[ni][nj] = seq
visited = [[False] * n for i in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
seq = 0

for row in range(n):
    for nd in range(n):
        if maps[row][nd] == 1 and not visited[row][nd]:
            seq += 1
            bfs(maps, visited, n, row, nd, dx, dy, seq)

print(seq)
count_house = 0
result = list()
for s in range(1, seq+1):
    for t in maps:
        count_house += t.count(s)
    result.append(count_house)
    count_house = 0

result.sort()       
for c in result:
    print(c) 

