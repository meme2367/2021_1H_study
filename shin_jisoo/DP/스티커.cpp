#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 100001

int buf[2][MAX];
int dp[2][MAX];

int DP(int n) {
	for (int i = 0;i < 2;i++) {
		for (int j = 0;j < n;j++) {
			cin >> buf[i][j];
		}
	}

	dp[0][0] = buf[0][0];
	dp[1][0] = buf[1][0];
	dp[0][1] = buf[0][1] + dp[1][0];
	dp[1][1] = buf[1][1] + dp[0][0];

	for (int i = 2;i < n;i++) {
		dp[0][i] = buf[0][i] + max(dp[1][i - 1], dp[1][i - 2]);
		dp[1][i] = buf[1][i] + max(dp[0][i - 1], dp[0][i - 2]);
	}

	return max(dp[0][n - 1], dp[1][n - 1]);
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int t;
	cin >> t;

	for (int i = 0;i < t;i++) {
		int n;
		cin >> n;

		cout << DP(n) << "\n";
	}
	return 0;
}