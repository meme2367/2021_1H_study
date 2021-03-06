#include <string>
#include <vector>
#include <algorithm>

#define max_int 101

using namespace std;

int parents[max_int];

int find(int node) {
    if (node == parents[node]) return node;

    else return parents[node] = find(parents[node]);
}

bool cmp(const vector<int>& a, const vector<int>& b) {
    return a[2] < b[2];
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;

    for (int i = 0;i < n;i++) {
        parents[i] = i;
    }

    sort(costs.begin(), costs.end(), cmp);

    for (int i = 0;i < costs.size();i++) {
        int start = find(costs[i][0]);
        int end = find(costs[i][1]);
        int cost = costs[i][2];

        if (start != end) {
            parents[start] = end;

            answer += cost;
        }
    }
    return answer;
}