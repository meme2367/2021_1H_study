#include <iostream>
using namespace std;

int n;
int memo[1001];

int dp(int pos){
    int &val = memo[pos];

    if(val != 0 || pos == 0){
        return val;
    }

    val += dp(pos - 1);
    val += dp(pos - 2);

    return val % 10007;
}

int main() {
    cin>>n;

    memo[1] = 1;
    memo[2] = 2;

    cout<<dp(n);
    return 0;
}

