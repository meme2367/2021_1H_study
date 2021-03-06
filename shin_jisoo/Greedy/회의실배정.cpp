#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool fastend_cmp(pair<int, int>a, pair<int, int>b) {
	if (a.second == b.second)return a.first < b.first;
	return a.second < b.second;
}

int main() {
	int n;
	cin >> n;
	vector<pair<int, int>>conference(n);
	int arr[25] = { 0, };

	for (int i = 0;i < n;i++) {
		cin >> conference[i].first >> conference[i].second;
	}

	sort(conference.begin(), conference.end(), fastend_cmp);

	int endtime = conference[0].second;
	int count = 1;
	for (int i = 1;i < n;i++) {
		if (endtime <= conference[i].first) {
			endtime = conference[i].second;
			count++;
		}
	}
	cout << count;
}