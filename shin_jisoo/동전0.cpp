#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int cmp(int a, int b) {
	return a > b;
}

int main() {
	int count = 0;
	int n, k;
	cin >> n >> k;
	vector<int>money(n);

	for (int i = 0;i < n;i++) {
		cin >> money[i];
	}

	sort(money.begin(), money.end(), cmp);

	for (int i = 0;i < n;i++) {
		while (k - money[i] >= 0) {
			k -= money[i];
			count++;
		}
	}

	cout << count;
}