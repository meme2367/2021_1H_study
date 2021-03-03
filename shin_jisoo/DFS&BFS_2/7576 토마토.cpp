#include <iostream>
#include <queue>
using namespace std;

#define MAX 101

typedef struct {
    int x, y, z;
    int cnt;
} types;

int m, n, h;
int box[MAX][MAX][MAX];
bool visited[MAX][MAX][MAX];
int dx[6] = { 1, -1, 0, 0, 0, 0 };
int dy[6] = { 0, 0, 1, -1, 0, 0 };
int dz[6] = { 0, 0, 0, 0, 1, -1 };
queue<types> bfs;

int main() {
    int cnt = 0;

    cin >> m >> n >> h;
    for (int k = 0; k < h; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                cin >> box[i][j][k];
                if (box[i][j][k] == 1) {
                    bfs.push({ i, j, k, 0 });
                    visited[i][j][k] = true;
                }
                else if (box[i][j][k] == -1)
                    visited[i][j][k] = true;
            }

    if (bfs.empty()) {
        printf("-1");
        return 0;
    }

    while (!bfs.empty()) {
        auto cur = bfs.front();
        bfs.pop();
        cnt = max(cnt, cur.cnt);

        for (int i = 0; i < 6; i++) {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];
            int nz = cur.z + dz[i];

            if (nx >= 0 && ny >= 0 && nz >= 0 && nx < n && ny < m && nz < h && !visited[nx][ny][nz]) {
                bfs.push({ nx, ny, nz, cur.cnt + 1 });
                visited[nx][ny][nz] = true;
            }
        }
    }

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            for (int k = 0; k < h; k++)
                if (!visited[i][j][k]) {
                    cout << -1;
                    return 0;
                }

    cout << cnt;
    return 0;

}