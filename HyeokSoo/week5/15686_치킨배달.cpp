#include <iostream>
#include <vector>
using namespace std;

struct pos{
    int y;
    int x;
};

vector<pos> house;
vector<pos> chicken;
vector<pos> selectedChicken;
int city[50][50];
int n, m, numChicken, ans = 2500;

int calc(){
    int sum = 0;
    for(int i=0;i<house.size();++i){
        int minD = 100;
        for(int j=0;j<m;++j){
            minD = min(minD, abs(house[i].y-selectedChicken[j].y) + abs(house[i].x-selectedChicken[j].x));
        }
        sum += minD;
    }

    return sum;
}

void selectChicken(int start, int cnt){
    if(cnt == m){
        ans = min(ans, calc());
        return;
    }

    for(int i=start;i<numChicken;++i){
        selectedChicken.push_back({chicken[i].y, chicken[i].x});
        selectChicken(i+1, cnt+1);
        selectedChicken.pop_back();
    }
}

int main() {
    int num;
    cin>>n>>m;

    for(int i=0;i<n;++i){
        for(int j=0;j<n;++j){
            cin>>num;
            city[i][j] = num;

            if(num == 1){
                house.push_back({i, j});
            }else if(num == 2){
                ++numChicken;
                chicken.push_back({i, j});
            }
        }
    }

    selectChicken(0, 0);
    cout<<ans;
    return 0;
}

