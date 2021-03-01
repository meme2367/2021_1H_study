import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

	static int m, n, k;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};

	public static void main(String[] args) throws java.lang.Exception {

       // System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
        
        
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[m][n];
            visit = new boolean[m][n];
            
            for(int i = 0;i<k;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }

            int ansCnt = 0;
            for(int i = 0;i<m;i++) {
                for(int j = 0;j<n;j++) {
                    if(map[i][j] == 1 && !visit[i][j]) {
                        ansCnt++;
                        dfs(i,j);
                    }
                }
            }

            System.out.println(ansCnt);

        }


    
    }

    static void dfs(int x,int y) {
        visit[x][y] = true;
        
        for(int i = 0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }

            if(map[nx][ny] == 1 && !visit[nx][ny]) {
                dfs(nx,ny);
            }
        }
    }
}