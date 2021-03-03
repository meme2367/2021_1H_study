#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int dy[4] = {1, -1, 0, 0};
int dx[4] = {0, 0, 1, -1};
int board[500][500];
int n, m, ans = -1;
bool visit[500][500];
vector<pair<int, int>> v;

void calc(int y, int x, int cnt, int sum){
    visit[y][x] = true;
    v.push_back({y, x});
    int curY, curX, nextY, nextX;

    for(int i=0;i<v.size();++i){
        curY = v[i].first;
        curX = v[i].second;

        for(int j=0;j<4;++j){
            nextY = curY + dy[j];
            nextX = curX + dx[j];

            if(0 <= nextY && nextY < n && 0 <= nextX && nextX < m){
                if(!visit[nextY][nextX]){
                    if(cnt == 3){
                        ans = max(ans, sum + board[nextY][nextX]);
                        continue;
                    }else{
                        calc(nextY, nextX, cnt+1, sum + board[nextY][nextX]);
                    }
                }
            }
        }
    }

    v.pop_back();
    visit[y][x] = false;
}

int main() {
    cin>>n>>m;
    for(int i=0;i<n;++i){
        for(int j=0;j<m;++j){
            cin>>board[i][j];
        }
    }

    for(int i=0;i<n;++i){
        for(int j=0;j<m;++j){
            calc(i, j, 1, board[i][j]);
        }
    }

    cout<<ans;
    return 0;
}

