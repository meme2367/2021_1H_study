import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {

	
	/**
    0 익지않은 토마토
    1 익은 토마토
    -1 들어있지 않은 칸
    모두 익지 못하는 상황 -1 출력
     토마토가 모두 익을 때까지의 최소 날짜를 출력
     */
	
	static int[] dx = {0,-1,0,1,0,0};
	static int[] dy = {1,0,-1,0,0,0};
    static int[] dh = {0,0,0,0,1,-1};

    static class Node {
        int x;
        int y;
        int h;
        int day;
        

        public Node(int x,int y,int h,int day) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.day = day;
            
        }
    }

	public static void main(String[] args) throws java.lang.Exception {

        System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken()); //가로
        int n = Integer.parseInt(st.nextToken()); //세로
        int h = Integer.parseInt(st.nextToken());

        int[][][] map = new int[n][m][h];
        int[][][] ch = new int[n][m][h];
        Queue<Node> q = new LinkedList<>();
        int zeroTomato = 0;
        int tomato = 0;
        int notTomato = 0;

        for(int k = 0;k<h;k++){
            for(int i = 0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0;j<m;j++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1) {
                        ch[i][j][k] = 1;
                        tomato++;
                        q.add(new Node(i,j,k,0));
                    }

                    if(map[i][j][k] == 0) {
                        zeroTomato++;
                    }

                    if(map[i][j][k] == -1) {
                        notTomato++;
                    }
                
                }
            }
        }

        //모든 토마토가 익어있으면 0출력
        if(tomato+notTomato == n*m*h) {
            System.out.println("0");
            return;
        }

        int ansDay = 0;
        int zero = 0;
        while(!q.isEmpty()) {
        
            Node node = q.poll();
            ansDay = node.day;

            for(int i = 0;i<6;i++) {
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];
                int nh = node.h+dh[i];
                int nday = node.day;

                if(nx < 0 || nx >= n || ny <0 || ny >= m || nh <0 || nh >= h) {
                    continue;
                }

                if(map[nx][ny][nh] == 0 && ch[nx][ny][nh] == 0) {
                    ch[nx][ny][nh] = 1;
                    map[nx][ny][nh] = 1;
                    zero++;
                    q.add(new Node(nx,ny,nh,nday+1));
                }
            }

        }



        if(zeroTomato == zero){
            System.out.println(ansDay);
        } else {
            System.out.println("-1");
        }

        

        
    }
}