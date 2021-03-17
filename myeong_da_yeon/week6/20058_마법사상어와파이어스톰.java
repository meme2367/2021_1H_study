import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {
    static int n,q;
    static int[][] map;
    static int[][] ch;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int ans;
    static int ansCnt = 0;
    static int size;

    static class Node {
        int x;
        int y;

        public Node(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

	public static void main(String[] args) throws java.lang.Exception {

        System.setIn(new FileInputStream("../input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        size = (1<<n);

        map = new int[size][size];
        for (int i = 0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<q;i++) {
            int l = Integer.parseInt(st.nextToken());
            if(l > 0) {
                rotateMap(l);
            }
            melt();
           
        }

//첫째 줄에 남아있는 얼음 A[r][c]의 합을 출력하고,

// 둘째 줄에 가장 큰 덩어리가 차지하는 칸의 개수를 출력한다. 
//단, 덩어리가 없으면 0을 출력한다.

        ch = new int[size][size];
        for(int i = 0;i<size;i++) {
            for(int j = 0;j<size;j++) {
                if(ch[i][j] == 0 && map[i][j] > 0) {
                    ansCnt = Math.max(ansCnt,dfs(i,j));
                }
            }
        }
        System.out.println(ans);
        System.out.println(ansCnt);

        
    }
    static int dfs(int xx,int yy) {
        ch[xx][yy] = 1;
        int cnt = 1;
        ans+= map[xx][yy];
        for(int i = 0;i<4; i++) {
            int nx = xx + dx[i];
            int ny = yy + dy[i];

            if(!check(nx,ny)) {
                continue;
            }
            if(map[nx][ny] > 0 && ch[nx][ny] == 0) {
                cnt += dfs(nx,ny);
            }
        }

        return cnt;
        
    }
    
    static void rotateMap(int l) {
        int pow = (1<<l);
        
    //2^l * 2^l로 나눈 후
        
        for (int i = 0;i<size;i+=pow) {
            for (int j = 0;j<size;j+=pow) {
                rotate(i,j,pow);
            }
        }

    }
    //90도 회전
    static void rotate(int x,int y,int L) {
    
        int[][] temp = new int[size][size];

        for(int i=0;i<L;i++) {
    		for(int j=0;j<L;j++) {
	    		temp[i][j]=map[y+L-1-j][x+i];
            }
        }

        for(int i=0;i<L;i++) {
            for(int j=0;j<L;j++) {
                map[y+i][x+j]=temp[i][j];
            }
        }
        

    }


    static void melt() {
    //해당 칸에 주변에 인접해있는 얼음이 3개미만이어야 얼음의 양이 준다.
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i<size;i++) {
            for(int j = 0;j<size;j++) {

                if(map[i][j] <= 0 ) {
                    continue;
                }

                int count = 0;
                for(int k = 0;k<4;k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(check(nx,ny)) {
                        if(map[nx][ny] >= 1) {
                            count++;
                        }
                    }
                }
                if(count < 3) {
                    q.add(new Node(i,j));
                }

            }
        }

        while(!q.isEmpty()) {
            Node n = q.poll();
            map[n.x][n.y]--;
        }
    }
    
    static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < size && y < size;
    }
}
