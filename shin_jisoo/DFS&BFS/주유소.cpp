#include<iostream>
#include<algorithm>
using namespace std;

#define MAX 1000000000

long long length[100001];
long long price_per_oil[100001];
long long answer, n;
long long min_price;

int main() {
	cin >> n;

	for (int i = 1; i <= n - 1; i++)
		cin >> length[i];

	for (int i = 1; i <= n; i++)
		cin >> price_per_oil[i];

	min_price = MAX;

	for (int i = 1; i <= n - 1; i++)
	{
		if (price_per_oil[i] < min_price) {
			min_price = price_per_oil[i];
		}
		answer += min_price * length[i];
	}

	cout << answer;

}