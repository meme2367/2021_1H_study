#include <iostream>
using namespace std;

long long p[101] = { 0,1,1, };

long long DP(int n) {
	if (n < 3) return p[n];

	else if (p[n] == 0) {
		p[n] = DP(n - 2) + DP(n - 3);
	}

	return p[n];
}

int main() {
	int t;
	cin >> t;

	for (int i = 0;i < t;i++) {
		int n;
		cin >> n;
		cout << DP(n) << "\n";
	}
	return 0;
}