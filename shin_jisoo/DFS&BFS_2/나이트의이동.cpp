#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

#define MAX 301
#define X first
#define Y second

int dx[8] = { 1,2,2,1,-1,-2,-2,-1 };
int dy[8] = { 2,1,-1,-2,-2,-1,1,2 };

int board[MAX][MAX];
bool visited[MAX][MAX];

int I;
queue<pair<int, int>> Q;
int src_x, src_y, dst_x, dst_y;

void bfs(int a, int b) {
	Q.push({ a,b });
	visited[a][b] = true;

	while (!Q.empty()) {
		auto cur = Q.front(); Q.pop();
		if (cur.X == dst_x && cur.Y == dst_y) {
			cout << board[cur.X][cur.Y] << "\n";

			while (!Q.empty()) Q.pop();

			break;
		}

		for (int dir = 0;dir < 8;dir++) {
			int nx = cur.X + dx[dir];
			int ny = cur.Y + dy[dir];

			if (nx >= 0 && nx < I && ny >= 0 && ny < I) {
				if (visited[nx][ny] == false) {
					visited[nx][ny] = true;
					board[nx][ny] = board[cur.X][cur.Y] + 1;
					Q.push({ nx,ny });
				}
			}
		}
	}
}

int main() {
	int t;
	cin >> t;

	for (int i = 0;i < t;i++) {
		cin >> I;
		cin >> src_x >> src_y >> dst_x >> dst_y;
		bfs(src_x, src_y);

		memset(board, 0, sizeof(board));
		memset(visited, false, sizeof(visited));
	}
	return 0;
}