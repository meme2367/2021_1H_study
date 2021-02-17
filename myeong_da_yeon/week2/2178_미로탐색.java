/* 1707. 이분 그래프 (dfs) */
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main
{

    static int n,m;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    public static void main (String[] args) throws java.lang.Exception
    {
        
        System.setIn(new FileInputStream("input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] ch = new int[n][m];

        for(int i = 0;i<n;i++) {
            String str = br.readLine();
            for(int j = 0;j<m;j++) {
                map[i][j] = str.charAt(j) - '0';
            
            }
        }

        Queue<Point> q = new LinkedList<>();
        //0,0 -> n-1,m-1
        ch[0][0] = 1;
        q.add(new Point(0,0));

        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            
            if(x == n-1 && y == m-1) {
                System.out.println(ch[p.x][p.y]);
                return;
            }
            

            for(int i = 0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if( map[nx][ny] == 1 && ch[nx][ny] == 0) {
                    ch[nx][ny] = ch[x][y] + 1;
                    q.add(new Point(nx,ny));


                }

            }
        }

    }
}

class Point {
    int x;
    int y;
    

    public Point (int x, int y ) {
        this.x = x;
        this.y = y;
        
    }
}