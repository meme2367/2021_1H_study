#include<iostream>
#include<string.h>
using namespace std;

#define MAX 51

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int board[MAX][MAX];
bool visit[MAX][MAX];
int testcase;
int N, M, num;

void dfs(int x, int y) {
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

		if (board[nx][ny] == 1 && !visit[nx][ny]) {
			visit[nx][ny] = true;
			dfs(nx, ny);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	cin >> testcase;

	while (testcase--) {
		int answer = 0;

		memset(board, 0, sizeof(board));
		memset(visit, false, sizeof(visit));

		cin >> N >> M >> num;
		for (int i = 0; i < num; i++) {
			int x, y;
			cin >> y >> x;
			board[x][y] = 1;
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1 && !visit[i][j]) {
					answer++;
					visit[i][j] = true;
					dfs(i, j);
				}
			}
		}

		cout << answer << "\n";
	}
	return 0;
}