#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 1;

    sort(routes.begin(), routes.end());

    int standard = routes[0][1];

    for (auto a : routes) {
        if (standard >= a[0]) {
            standard = min(a[1], standard);
        }
        else {
            answer++;
            standard = a[1];
        }
    }

    return answer;
}