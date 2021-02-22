#!/usr/bin/env python
# coding: utf-8

# In[ ]:


from collections import deque

n, m = map(int, input().split())
maze = list(list(map(int, input())) for i in range(n))

def bfs(graph, visited, i, j, dx, dy, n, m):
    que = deque([(i, j)])
    visited[i][j] = True
    
    while que:
        v = que.popleft()
        pre_y = i = v[0]
        pre_x = j = v[1]
        
        for p in range(len(dx)):
            y = i + dy[p]
            x = j + dx[p]

            if 0 <= x < m and 0 <= y < n:
                if graph[y][x] == 1 and not visited[y][x]:
                    visited[y][x] = True
                    graph[y][x] = graph[pre_y][pre_x] + 1
                    que.append((y, x))
                    
visited = [[False] * m for i in range(n)]
# 상하좌우
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
bfs(maze, visited, 0, 0, dx, dy, n, m)
print(maze[n-1][m-1])

