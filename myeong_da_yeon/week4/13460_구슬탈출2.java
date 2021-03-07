import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

	static int n,m;

	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};

/*
세로 n , 가로 m (3 ≤ N, M ≤ 10)
'.' : 빈 칸 
'#' : 공이 이동할 수 없는 장애물 또는 벽
'O' : 구멍의 위치
'R' : 빨간 구슬의 위치
'B' : 파란 구슬의 위치
가장자리에는 모두 #
구멍 개수 1개
빨간 구슬 , 파란 구슬 항상 1개
=> 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 출력
=> 10번 초과 -1 출력

파란 구슬이 구멍에 빠지면 실패, 동시에 빠져도 실패 ->  빨간 구슬 먼저 움직임

*/

    static class Node {
        int rx;
        int ry;
        int bx;
        int by;
        

        public Node(int rx,int ry,int bx,int by) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            
        }
    }

	public static void main(String[] args) throws java.lang.Exception {

        //System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] map = new char[n][m];
        int[][][][] ch = new int[n][m][n][m];
        sc.nextLine();
        

        int rxx = 0;
        int ryy = 0; 
        int bxx = 0;
        int byy = 0;
        for(int i = 0;i<n;i++) {
            String str = sc.next();
            for(int j = 0;j<m;j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'B') {
                    bxx = i;
                    byy = j;
                }

                if(map[i][j] == 'R') {
                    rxx = i;
                    ryy = j;
                }
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(rxx,ryy,bxx,byy));
        ch[rxx][ryy][bxx][byy] = 1;


        while(!q.isEmpty()) {
            Node node = q.poll();


            if(ch[node.rx][node.ry][node.bx][node.by]-1 > 10) {
                System.out.println("-1");
                return;
            }

            //구멍에 빨간 공, 파란 공 들어간 경우에는 아래 for문을 돌긴하는데 이미 체크되있어서 넘어감
            if(map[node.rx][node.ry] == 'O' && map[node.rx][node.ry] != map[node.bx][node.by]) {
                System.out.println(ch[node.rx][node.ry][node.bx][node.by]-1);
                return;
            }

            for(int i = 0;i<4;i++) {
                int rcnt = 0;
                int bcnt = 0;
                int rx = node.rx;
                int ry = node.ry;
                int bx = node.bx;
                int by = node.by;
                
                while(map[rx+dx[i]][ry+dy[i]] != '#' && map[rx][ry] != 'O' ) {
                    rx += dx[i];
                    ry += dy[i];
                    rcnt++;
                }
                
                

                while(map[bx+dx[i]][by+dy[i]] != '#' && map[bx][by] != 'O') {
                    bx += dx[i];
                    by += dy[i];
                    bcnt++;
                }
//...RB -> RB... (R이 3번 움직임, B는 4번 움직임) => 더 많이 움직인 쪽을 옮겨야됨 
//O..RB -> -1

//RB... -> ...RB (R이 4번, B가 3번) => 더 많이 움직인 R을 옮기기
//RB..O -> R,B가 구멍에 다 빠져버림 -> -1



                if((rx == bx) && (ry == by)) {

                    if(map[rx][ry] == 'O') {
                        continue;
                    }

                    if(rcnt < bcnt) {
                        bx -= dx[i];
                        by -= dy[i];
                    } else {
                        rx -= dx[i];
                        ry -= dy[i];
                    }
                }

                if(ch[rx][ry][bx][by] > 0) {
                    continue;
                }

               
               
                q.add(new Node(rx,ry,bx,by));
                ch[rx][ry][bx][by] = ch[node.rx][node.ry][node.bx][node.by]+1;



            }

        }

        System.out.println("-1");
        
    }
}