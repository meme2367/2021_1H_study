#include <iostream>
using namespace std;

int dp[1001];
int arr[1001];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int max = 0;
	int n;
	cin >> n;

	for (int i = 1;i <= n;i++) {
		cin >> arr[i];
	}

	for (int i = 1;i <= n;i++) {
		dp[i] = 1;
		for (int j = 1;j < i;j++) {
			if (arr[i] < arr[j] && dp[i] < dp[j] + 1) {
				dp[i] = dp[j] + 1;
			}
		}
		if (max < dp[i]) {
			max = dp[i];
		}
	}

	cout << max;
}