#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct schedule{
    int t;
    int p;
};

int n, ans;
int dp[17];
vector<schedule> v(1, {0,0});


int main() {
    cin>>n;

    int tempT, tempP;
    for(int i=0;i<n;++i){
        cin>>tempT>>tempP;
        v.push_back({tempT, tempP});
    }

    for(int i=1;i<=n;++i){
        ans = max(ans, dp[i]);
        if(i + v[i].t <= n + 1){
            dp[i + v[i].t] = max(ans + v[i].p, dp[i + v[i].t]);
        }
    }

    ans = max(ans, dp[n+1]);
    cout<<ans;
    return 0;
}
