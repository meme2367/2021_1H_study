import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {

    static class FireBall {
        int r;
        int c;
        int m;
        int s;
        int d;

        public FireBall(int r,int c,int m,int s,int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int n,m,k,ans;
    //0 ~ 7
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static LinkedList<FireBall> fb;
    static LinkedList<FireBall> map[][];
    
	public static void main(String[] args) throws java.lang.Exception {

        System.setIn(new FileInputStream("../input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken()); 
        k = Integer.parseInt(st.nextToken()); 

        
        /*
        n*n
        방향 d로 속력 s칸만큼 이동
        r 행
        c 열
        m 질량
        s 속력 
        d 방향
        마법사 상어가 이동을 K번 명령한 후, 남아있는 파이어볼 질량의 합을 출력
         */

        fb = new LinkedList<>();
        map = new LinkedList[n][n];

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                map[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); 
            int c = Integer.parseInt(st.nextToken()); 
            int m = Integer.parseInt(st.nextToken()); 
            int s = Integer.parseInt(st.nextToken()); 
            int d = Integer.parseInt(st.nextToken()); 
            map[r-1][c-1].add(new FireBall(r-1,c-1,m,s,d));
        }

        solve();
        
        System.out.println(ans);
    
    }

    static void solve() {
        while(k-- > 0) {
            move();
            sum();
        }
        
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                for(FireBall fbb : map[i][j]) {
                    ans += fbb.m;
                }
            }
        }
        

    }

    static void move() {

        LinkedList<FireBall> newMap[][] = new LinkedList[n][n];

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                newMap[i][j] = new LinkedList<>();
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j].size() >= 1) {
                    for (FireBall fbb : map[i][j]) {
                        int ns = (fbb.s % n);
                        int nx = fbb.r + (dx[fbb.d]*ns);
                        int ny = fbb.c + (dy[fbb.d]*ns);

                        if(nx >= n) {
                            nx -= n;
                        } else if(nx < 0) {
                            nx += n;
                        }

                        if(ny >= n) {
                            ny -= n;
                        } else if(ny <0) {
                            ny += n;
                        }

                        fbb.r = nx;
                        fbb.c = ny;
                        newMap[nx][ny].add(fbb);
                    }
                
                }
                
            }
        }

        map = newMap;
    }

    static void sum() {
        

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++){

                if(map[i][j].size() == 0) {
                    continue;
                }


                if(map[i][j].size() == 1) {
                    continue;
                }

                int sumM = 0;
                int sumS = 0;
                boolean odd = true;//홀수
                boolean even = true;//짝수
                for(int z = 0;z < map[i][j].size();z++) {
                    sumM += map[i][j].get(z).m;
                    sumS += map[i][j].get(z).s;
                    if(map[i][j].get(z).d % 2 == 0) {
                        odd = false;
                    } else {
                        even = false;
                    }

                }
                
                int curM = sumM/5;
                int curS = (sumS/map[i][j].size());
                map[i][j].clear();
                if(curM != 0) {
                    for(int l = 0;l<4;l++) {
                        if(odd || even) {
                            map[i][j].add(new FireBall(i,j,curM,curS,l*2));

                        } else {
                            map[i][j].add(new FireBall(i,j,curM,curS,l*2+1));
                        }
                        
                    }
                }
                
            }
        }

        



    }
}