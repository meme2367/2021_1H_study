#include <iostream>
#include <cstring> //memset
using namespace std;

#define MAX 100001

int n, cnt;
int want[MAX];
bool visited[MAX];
bool done[MAX];

void dfs(int nodeNum) {
	visited[nodeNum] = true;

	int next = want[nodeNum];
	if (!visited[next]) dfs(next);

	else if (!done[next]) {
		for (int i = next;i != nodeNum;i = want[i]) cnt++;
		cnt++;
	}

	done[nodeNum] = true;
}

int main() {
	int t;
	cin >> t;

	for (int i = 0;i < t;i++) {
		memset(visited, false, sizeof(visited));
		memset(done, false, sizeof(done));
		cin >> n;

		for (int j = 1;j <= n;j++) {
			cin >> want[j];
		}
		cnt = 0;
		for (int j = 1;j <= n;j++) {
			if (!visited[j]) dfs(j);
		}

		cout << n - cnt << "\n";
	}
	return 0;
}