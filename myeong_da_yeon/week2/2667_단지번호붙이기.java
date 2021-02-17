/* 1712_손익분기점 */
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main
{
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] map;
    static int[][] ch;
    static int n;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main (String[] args) throws java.lang.Exception
    {
        
        System.setIn(new FileInputStream("input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    
        map = new int[n][n];
        ch = new int[n][n];

        for(int i = 0;i<n;i++) {
            String str = br.readLine();
            for(int j = 0;j<n;j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        int idx = 0;

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                if(map[i][j] == 1 && ch[i][j] == 0) {
                    ++idx;
                    arr.add(bfs(i,j));
                }
            }
        }

        Collections.sort(arr);

        System.out.println(idx);
        
        for(int i = 0;i<arr.size();i++) {
            System.out.println(arr.get(i));
        }

    }

    static int bfs(int a,int b) {
        Queue<Point> q = new LinkedList<>();
        ch[a][b] = 1;
        int cnt = 1;
        q.add(new Point(a,b));
        

        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int i = 0;i<4;i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx < 0 || nx >=n || ny < 0 || ny >= n) {
                    continue;
                }

                if(ch[nx][ny] == 0 && map[nx][ny] == 1) {
                    ch[nx][ny] = 1;
                    q.add(new Point(nx,ny));
                    cnt++;
                }
            }


        }

        return cnt;

    }
}

class Point {
    int x;
    int y;

    public Point(int x,int y) {
        this.x = x;
        this.y = y;
    }
}