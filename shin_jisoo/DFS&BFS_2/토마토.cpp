#include <iostream>
#include <queue>
using namespace std;

#define MAX 1002
#define X first
#define Y second

int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };
int board[MAX][MAX];
int dist[MAX][MAX];
int n, m;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	queue<pair<int, int>>Q;

	cin >> m >> n;
	for (int i = 0;i < n;i++) {
		for (int j = 0;j < m;j++) {
			cin >> board[i][j];
			if (board[i][j] == 1)
				Q.push({ i,j });
			if (board[i][j] == 0)
				dist[i][j] = -1;

		}
	}

	while (!Q.empty()) {
		auto cur = Q.front(); Q.pop();
		for (int dir = 0;dir < 4;dir++) {
			int nx = cur.X + dx[dir];
			int ny = cur.Y + dy[dir];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue;
			if (dist[nx][ny] >= 0)continue;
			dist[nx][ny] = dist[cur.X][cur.Y] + 1;
			Q.push({ nx,ny });
		}
	}

	int answer = 0;
	for (int i = 0;i < n;i++) {
		for (int j = 0;j < m;j++) {
			if (dist[i][j] == -1) {
				cout << -1;
				return 0;
			}
			answer = max(answer, dist[i][j]);
		}
	}
	cout << answer;
}