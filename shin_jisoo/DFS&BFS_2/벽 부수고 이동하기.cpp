#include <iostream>
#include <queue>
#include <algorithm>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
using namespace std;

#define MAX 1001

int n, m;
int board[MAX][MAX];
bool visit[MAX][MAX][2] = { false, };
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };

int bfs() {
	queue<pair<pair<int, int>, pair<int, int>>>Q;
	Q.push(make_pair(make_pair(0,0),make_pair(1,1)));
	visit[0][0][1] = true;

	while (!Q.empty()) {
		int x = Q.front().first.first;
		int y = Q.front().first.second;
		int wall = Q.front().second.first;
		int cnt = Q.front().second.second;
		Q.pop();

		if (x == n - 1 && y == m - 1)return cnt;
		for (int dir = 0;dir < 4;dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue;
			if (board[nx][ny] == 1 && wall == 1) {
				visit[nx][ny][wall] = true;
				Q.push(make_pair(make_pair(nx, ny), make_pair(wall - 1, cnt + 1)));
			}
			if (board[nx][ny] == 0 && !visit[nx][ny][wall]) {
				visit[nx][ny][wall] = true;
				Q.push(make_pair(make_pair(nx, ny), make_pair(wall, cnt + 1)));
			}
		}
	}
	return -1;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	cin >> n >> m;

	for (int i = 0;i < n;i++) {
		string tmp;
		cin >> tmp;
		for (int j = 0;j < m;j++)
			board[i][j] = tmp[j] - '0';
	}
	cout << bfs();
	return 0;
}