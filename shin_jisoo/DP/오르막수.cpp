#include <iostream>
using namespace std;

#define MAX 1001
#define mod 10007

int dp[MAX][10];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n;
	cin >> n;

	//첫번째 자리는 1로 초기화
	for (int i = 0;i < 10;i++) dp[0][i] = 1;
	
	for (int i = 1;i < n;i++) {
		for (int j = 0;j < 10;j++) {
			for (int k = j;k < 10;k++) {
				dp[i][k] += dp[i - 1][j];
				dp[i][k] %= mod;
			}
		}
	}

	int sum = 0;

	for (int i = 0;i < 10;i++) sum += dp[n - 1][i];
	cout << sum % mod;


}