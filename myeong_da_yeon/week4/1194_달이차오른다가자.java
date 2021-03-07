import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {

	
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};

    static class Node {
        int x;
        int y;
        int k;

        public Node(int x,int y,int k) {
            this.x = x;
            this.y = y;
            this.k = k;
            
            
        }
    }

	public static void main(String[] args) throws java.lang.Exception {

        System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //가로
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        int[][][] visited = new int[n][m][64]; // 2^6 = 64

        Queue<Node> q = new LinkedList<>();

        for(int i = 0;i<n;i++){
            char[] str = br.readLine().toCharArray();
            for(int j = 0;j<m;j++) {
                map[i][j] = str[j];

                if(map[i][j] == '0') {
                    
                    visited[i][j][0] = 1;
                    q.add(new Node(i,j,0));
                }
            }
        }

        while(!q.isEmpty()) {
            Node node = q.poll();

            int x = node.x;
            int y = node.y;
            int k = node.k;
                                
            if(map[x][y] == '1') {
                System.out.println(visited[x][y][k]-1);
                return;
            }

            for(int i = 0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nk = k;

                if(nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == '#' || visited[nx][ny][nk] != 0) {
                    continue;
                }

                
                if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
                    nk |= (1<<(map[nx][ny] - 'a')); //키 추가
                } else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
                    if((nk & (1<<map[nx][ny]-'A')) == 0) {
                        //키 없더라
                        continue;
                    }                    
                }

                visited[nx][ny][nk] = visited[x][y][k] + 1;
                q.add(new Node(nx,ny,nk));
                
            }
        }

        System.out.println("-1");

        
    }
}