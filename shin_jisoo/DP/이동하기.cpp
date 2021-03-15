#include <iostream>
#include <algorithm>
using namespace std;

#define MAX 1001

int arr[MAX][MAX];
int copy_arr[MAX][MAX];
int n, m;

int dp() {
	for (int i = 1;i <= n;i++) {
		for (int j = 1;j <= m;j++) {
			int compare_number = 0;

			compare_number = max(copy_arr[i - 1][j - 1], 
				max(copy_arr[i - 1][j], copy_arr[i][j - 1]));
			copy_arr[i][j] = compare_number + arr[i][j];
		}
	}
	return copy_arr[n][m];
}

int main() {
	cin >> n >> m;

	for (int i = 1;i <= n;i++) {
		for (int j = 1;j <= m;j++) {
			cin >> arr[i][j];
		}
	}

	cout << dp() << "\n";
	return 0;
}