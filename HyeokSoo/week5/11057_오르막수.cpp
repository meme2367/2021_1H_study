#include <iostream>
using namespace std;


int n;
int memo[1001][10];

int dp(int d, int num){
    int &val = memo[d][num];

    if(val != 0){
        return val;
    }

    for(int i=num;i<10;++i){
        val += dp(d-1, i);
    }

    val %= 10007;
    return val;
}

int main() {
    int ans = 0;

    cin>>n;
    for(int i=0;i<10;++i){
        memo[1][i] = 1;
    }

    for(int i=0;i<10;++i){
        ans += dp(n, i);
    }

    cout<<ans % 10007;
    return 0;
}

