#!/usr/bin/env python
# coding: utf-8

# - 정답

# In[8]:


DEPARTURE, DESTINATION = 0, 1

def func(answer, visited, tickets, count_route, now):
    if count_route == len(tickets):
        return True
    else:
        for idx, ticket in enumerate(tickets):
            if not visited[idx] and ticket[DEPARTURE] == now:
                answer[count_route] = ticket[DESTINATION]
                next_one = ticket[DESTINATION]
                visited[idx] = True
                finished = func(answer, visited, tickets, count_route + 1, next_one)
                if finished:
                    return True
                else:
                    func(answer, visited, tickets, count_route, now)
                    visited[idx] = False

def solution(tickets):
    tickets.sort()
    answer = [0] * len(tickets)
    visited = [False] * len(tickets)
    func(answer, visited, tickets, 0, "ICN")
    return ["ICN"] + answer


# - 디버깅

# In[51]:


DEPARTURE, DESTINATION = 0, 1

def func(answer, visited, tickets, count_route, now):
    print("count_route", count_route)
    if count_route == len(tickets):
        print("끝")
        return True
    else:
        for idx, ticket in enumerate(tickets):
#             print(idx, ticket)
            if not visited[idx] and ticket[DEPARTURE] == now:
                answer[count_route] = ticket[DESTINATION]
                next_one = ticket[DESTINATION]
                visited[idx] = True
                print(ticket[DEPARTURE], answer, count_route, visited)
                finished = func(answer, visited, tickets, count_route + 1, next_one)
                if finished:
                    return True
                else:
                    func(answer, visited, tickets, count_route, now)
                    visited[idx] = False


# In[54]:


# tickets = [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]
tickets = [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]]
# tickets = [["ICN", "B"], ["B", "ICN"], ["ICN","A"]]


tickets.sort()
print(len(tickets), tickets)
answer = [0] * len(tickets)
visited = [False] * len(tickets)
func(answer, visited, tickets, 0, "ICN")
print("답: ", ["ICN"] + answer)


# In[ ]:




