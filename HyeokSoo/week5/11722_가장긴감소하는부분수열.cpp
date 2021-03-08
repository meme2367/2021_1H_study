#include <iostream>
#include <algorithm>
using namespace std;

int num[1001];
int dp[1001];
int n, ans = -1;

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    cin>>n;
    for(int i=1;i<=n;++i){
        cin>>num[i];
    }

    for(int i=1;i<=n;++i){
        dp[i] = 1;
        for(int j=1;j<i;++j){
            if(num[i] < num[j]){
                dp[i] = max(dp[j] + 1, dp[i]);
            }
        }

        ans = max(ans, dp[i]);
    }

    cout<<ans;
    return 0;
}

