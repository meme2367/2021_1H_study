#include <iostream>
#include <vector>
#include <memory.h>
using namespace std;

struct idx{
    int start;
    int end;
};

int n, m;
int num[2001];
int memo[2001][2001];
vector<idx> v;

int dp(int s, int e){
    int &val = memo[s][e];
    if(val != -1){
        return val;
    }

    if(s == e){
        val = 1;
    }else if(num[s] != num[e]){
        val = 0;
    }else{
        if(s < e-1){
            val = dp(s+1, e-1);
        }else{
            val = 1;
        }
    }

    return val;
}

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int s, e;

    cin>>n;
    for(int i=1;i<=n;++i){
        cin>>num[i];
        memset(memo[i], -1, (n+1)*4);
    }

    cin>>m;
    for(int i=0;i<m;++i){
        cin>>s>>e;
        v.push_back({s, e});
    }

    for(idx i : v){
        cout<<dp(i.start, i.end)<<"\n";
    }

    return 0;
}
