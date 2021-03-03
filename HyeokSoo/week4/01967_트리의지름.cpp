#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct edge{
    int vertex;
    int weight;
};

int n, maxW = -1, maxV;
vector<vector<edge>> v(10001);
bool visit[10001];

void dfs(int curV, int curW){
    visit[curV] = true;

    int nextV, nextW;
    for(int i=0;i<v[curV].size();++i){
        nextV = v[curV][i].vertex;
        nextW = curW + v[curV][i].weight;
        if(!visit[nextV]){
            if(maxW < nextW){
                maxW = nextW;
                maxV = nextV;
            }

            dfs(nextV, nextW);
        }
    }

    visit[curV] = false;
}

int main() {
    int v1, v2, w;

    cin>>n;
    for(int i=0;i<n-1;++i){
        cin>>v1>>v2>>w;
        v[v1].push_back({v2, w});
        v[v2].push_back({v1, w});
    }

    dfs(1, 0);
    maxW = 0;
    dfs(maxV, 0);

    cout<<maxW;
    return 0;
}

// 증명 참고 - https://www.weeklyps.com/entry/%ED%8A%B8%EB%A6%AC%EC%9D%98-%EC%A7%80%EB%A6%84
