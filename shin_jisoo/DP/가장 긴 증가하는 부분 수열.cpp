#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 1000

int dp[MAX];
int arr[MAX];
int answer;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int n;
	cin >> n;

	for (int i = 0;i < n;i++) {
		cin >> arr[i];
	}

	for (int i = 0;i < n;i++) {
		dp[i] = 1;
		for (int j = 0;j < i;j++) {
			if (arr[i] > arr[j]) {
				dp[i] = max(dp[i], dp[j] + 1);
			}
		}
		answer = max(answer, dp[i]);
	}

	cout << answer;
}