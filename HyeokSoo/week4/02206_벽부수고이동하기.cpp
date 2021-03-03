#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct state{
    int y;
    int x;
    int cnt;
    int crash;
};

vector<string> map(1001, "x");
int n, m;
int dy[4] = {1, -1, 0, 0};
int dx[4] = {0, 0, 1, -1};
bool visit[1001][1001][2];

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    string str;
    queue<state> q;
    cin>>n>>m;

    for(int i=1;i<=n;++i){
        cin>>str;
        map[i].append(str);
    }

    q.push({1, 1, 1, 0});
    visit[1][1][0] = true;
    int curY, curX, nextY, nextX, curCnt, curCrash;
    char nextV;

    while(!q.empty()){
        curY = q.front().y;
        curX = q.front().x;
        curCnt = q.front().cnt;
        curCrash = q.front().crash;
        q.pop();

        if(curY == n && curX == m){
            cout<<curCnt;
            return 0;
        }

        for(int i=0;i<4;++i){
            nextY = curY + dy[i];
            nextX = curX + dx[i];
            nextV = map[nextY][nextX];

            if(1 <= nextY && nextY <= n && 1 <= nextX && nextX <= m){
                if(curCrash == 0){
                    if(!visit[nextY][nextX][0]){
                        if(nextV == '0'){
                            q.push({nextY, nextX, curCnt+1, 0});
                            visit[nextY][nextX][0] = true;
                        }else {
                            q.push({nextY, nextX, curCnt + 1, 1});
                            visit[nextY][nextX][1] = true;
                        }
                    }
                }else{
                    if(!visit[nextY][nextX][1]){
                        if(nextV == '0'){
                            q.push({nextY, nextX, curCnt+1, 1});
                            visit[nextY][nextX][1] = true;
                        }
                    }
                }
            }
        }
    }

    cout<<-1;
    return 0;
}

