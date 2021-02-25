#include <iostream>
using namespace std;

int m, n, t, k;
bool ground[50][50];
bool visit[50][50];

int dy[4] = {1, -1, 0, 0};
int dx[4] = {0, 0, 1, -1};

void dfs(int y, int x){
    int nextY, nextX;

    visit[y][x] = true;
    for(int i=0;i<4;++i){
        nextY = y + dy[i];
        nextX = x + dx[i];

        if(
                0 <= nextY && nextY < m &&
                0 <= nextX && nextX < n &&
                ground[nextY][nextX] && !visit[nextY][nextX]
                ){
            dfs(nextY, nextX);
        }
    }
}

int main() {
    cin>>t;
    for(int i=0;i<t;++i){
        int y, x, ans = 0;

        cin>>m>>n>>k;
        for(int p=0;p<m;++p){
            for(int q=0;q<n;++q){
                ground[p][q] = false;
                visit[p][q] = false;
            }
        }

        for(int j=0;j<k;++j){
            cin>>y>>x;
            ground[y][x] = true;
        }

        for(int p=0;p<m;++p){
            for(int q=0;q<n;++q){
                if(ground[p][q]){
                    if(!visit[p][q]){
                        ++ans;
                        dfs(p, q);
                    }
                }
            }
        }

        cout<<ans<<"\n";
    }
    return 0;
}

