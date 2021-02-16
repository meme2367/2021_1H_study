#include <iostream>
#include <queue>

using namespace std;

#define X first
#define Y second
int board[102][102];
int dist[102][102];
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };
int n, m, area;

int main() {
	cin >> n >> m;

	for (int i = 0;i < n;i++) {
		string tmp;
		cin >> tmp;
		for (int j = 0;j < m;j++) {
			board[i][j] = tmp[j] - '0';
			dist[i][j] = -1;
		}
	}

	queue<pair<int, int>>Q;
	Q.push({ 0,0 });
	dist[0][0] = 0;

	while (!Q.empty()) {
		area++;
		pair<int, int>cur = Q.front(); Q.pop();
		for (int dir = 0;dir < 4;dir++) {
			int nx = cur.X + dx[dir];
			int ny = cur.Y + dy[dir];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue;
			if (board[nx][ny] != 1 || dist[nx][ny] >= 0)continue;
			Q.push({ nx,ny });
			dist[nx][ny] = dist[cur.X][cur.Y] + 1;
		}
	}

	cout << dist[n - 1][m - 1] + 1;
}