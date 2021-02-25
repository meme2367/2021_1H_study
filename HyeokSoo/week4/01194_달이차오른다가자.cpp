#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

struct state{
    int y;
    int x;
    int cnt;
    int key;
};

bool visit[50][50][64];
string board[50];
int n, m, startY, startX;
int dy[4] = {1, -1, 0, 0};
int dx[4] = {0, 0, 1, -1};
queue<state> q;

int main() {
    cin>>n>>m;
    for(int i=0;i<n;++i){
        cin >> board[i];
        if(board[i].find('0') != -1){
            startY = i;
            startX = board[i].find('0');
        }
    }

    int curY, curX, nextY, nextX, cnt, key;
    char nextK, nextV;

    q.push({startY, startX, 0, 0});
    visit[startY][startX][0] = true;

    while(!q.empty()){
        curY = q.front().y;
        curX = q.front().x;
        cnt = q.front().cnt;
        key = q.front().key;

        q.pop();

        for(int i=0;i<4;++i){
            nextY = curY + dy[i];
            nextX = curX + dx[i];

            if(0 <= nextY && nextY < n && 0 <= nextX && nextX < m){
                if(!visit[nextY][nextX][key]){
                    nextV = board[nextY][nextX];
                    if(nextV == '1'){
                        cout<<cnt+1;
                        return 0;
                    }else if(nextV == '#'){
                        continue;
                    }else if(65 <= nextV && nextV <= 90){
                        if((key & 1<<(nextV-65)) != 0){
                            visit[nextY][nextX][key] = true;
                            q.push({nextY, nextX, cnt+1, key});
                        }
                    }else{
                        int newKey = key;
                        if(97 <= nextV && nextV <= 122){
                             newKey = key | 1<<(nextV-97);
                        }
                        visit[nextY][nextX][key] = true;
                        q.push({nextY, nextX, cnt+1, newKey});
                    }
                }
            }
        }
    }

    cout<<-1;
    return 0;
}

