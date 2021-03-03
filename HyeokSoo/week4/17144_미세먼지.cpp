#include <iostream>
#include <queue>
using namespace std;

struct info{
    int y;
    int x;
    int amount;
};

int a[50][50];
int r, c, t, cnt, ac1, ac2;
int dr[4] = {1, -1, 0, 0};
int dc[4] = {0, 0, 1, -1};
queue<info> q;

void spread(){
    int nextR, nextC, val;

    for(int i=0;i<r;++i){
        for(int j=0;j<c;++j){
            val = a[i][j];
            if(((i == ac1 || i == ac2) && j == 0) || val == 0){
                continue;
            }

            for(int k=0;k<4;++k){
                nextR = i + dr[k];
                nextC = j + dc[k];

                if(0 <= nextR && nextR < r && 0 <= nextC && nextC < c){
                    if((nextR == ac1 || nextR == ac2) && nextC == 0){
                        continue;
                    }

                    q.push({nextR, nextC, val / 5});
                    q.push({i, j, val / 5 * -1});
                }
            }
        }
    }

    while(!q.empty()){
        a[q.front().y][q.front().x] += q.front().amount;
        q.pop();
    }
}

void airCleaner(){
    cnt -= a[ac1-1][0];
    for(int i=ac1-1;i>0;--i){
        a[i][0] = a[i-1][0];
    }
    for(int j=0;j<c-1;++j){
        a[0][j] = a[0][j+1];
    }
    for(int i=0;i<ac1;++i){
        a[i][c-1] = a[i+1][c-1];
    }
    for(int j=c-1;j>1;--j){
        a[ac1][j] = a[ac1][j-1];
    }
    a[ac1][1] = 0;

    cnt -= a[ac2+1][0];
    for(int i=ac2+1;i<r-1;++i){
        a[i][0] = a[i+1][0];
    }
    for(int j=0;j<c-1;++j){
        a[r-1][j] = a[r-1][j+1];
    }
    for(int i=r-1;i>ac2;--i){
        a[i][c-1] = a[i-1][c-1];
    }
    for(int j=c-1;j>1;--j){
        a[ac2][j] = a[ac2][j-1];
    }
    a[ac2][1] = 0;
}

int main() {
    int num;

    cin>>r>>c>>t;
    for(int i=0;i<r;++i){
        for(int j=0;j<c;++j){
            cin>>num;
            a[i][j] = num;

            if(num == -1){
                if(ac1 == 0){
                    ac1 = i;
                }else{
                    ac2 = i;
                }

            }else{
                cnt += num;
            }
        }
    }

    for(int i=0;i<t;++i){
        spread();
        airCleaner();
    }

    cout<<cnt;
    return 0;
}

