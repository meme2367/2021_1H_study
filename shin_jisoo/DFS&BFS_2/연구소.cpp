#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
int answer = 0;

int dx[4] = { 0, 0, 1, -1 };
int dy[4] = { 1, -1, 0, 0 };

void check_bfs(vector<vector<int>>& v) {
	queue<pair<int, int>> Q;

	for (int i = 0; i < v.size(); i++) {
		for (int j = 0; j < v[i].size(); j++) {
			if (v[i][j] == 2)
				Q.push({ i,j });
		}
	}

	while (!Q.empty()) {
		int x = Q.front().first;
		int y = Q.front().second;
		Q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx > -1 && nx < v.size() && ny > -1 && ny < v[x].size() &&
				v[nx][ny] == 0) {
				Q.push({ nx,ny });
				v[nx][ny] = 2;
			}
		}
	}

	int cnt = 0;
	for (int i = 0; i < v.size(); i++) {
		for (int j = 0; j < v[i].size(); j++) {
			if (v[i][j] == 0)
				cnt++;
		}
	}
	answer = max(answer, cnt);
}

void dfs(vector<vector<int>> v, int x, int y, int cnt) {
	v[x][y] = 1;

	if (cnt == 0) {
		check_bfs(v);
		return;
	}

	for (int i = x; i < v.size(); i++) {
		for (int j = 0; j < v[x].size(); j++) {
			if (v[i][j] == 0)
				dfs(v, i, j, cnt - 1);
		}
	}
}

int main() {
	int n, a, b, m;

	cin >> n >> m;

	vector<vector<int>> v(n, vector<int>(m));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			cin >> v[i][j];
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (v[i][j] == 0)
				dfs(v, i, j, 2);
		}
	}

	cout << answer << "\n";
	return 0;
}