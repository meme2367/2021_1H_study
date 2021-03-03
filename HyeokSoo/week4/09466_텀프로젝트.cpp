#include <iostream>
#include <memory.h>
#include <vector>
using namespace std;

vector<pair<int, int>> v;
bool visit[100001];
bool visitEnd[100001];
int t, n, num, cnt;

void dfs(int cur, int seq){
    visit[cur] = true;
    v[cur].second = seq;
    int nextP = v[cur].first;

    if(!visit[nextP]){
        dfs(nextP, seq+1);
    }else{
        if(!visitEnd[nextP]){
            cnt += (seq - v[nextP].second + 1);
        }
    }

    visitEnd[cur] = true;
}

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    cin>>t;
    for(int i=0;i<t;++i){
        cin>>n;
        memset(visit, false, 100001);
        memset(visitEnd, false, 100001);
        v.clear(); v.push_back({0, 0});
        cnt = 0;

        for(int j=1;j<=n;++j){
            cin>>num;
            v.push_back({num, 1});
        }

        for(int j=1;j<=n;++j){
            if(!visit[j]){
                dfs(j, 1);
            }
        }

        cout<<n-cnt<<"\n";
    }

    return 0;
}

