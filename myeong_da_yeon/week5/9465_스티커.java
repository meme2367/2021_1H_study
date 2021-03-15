import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {

    
/*d[i][j] = 2*j에서 얻을 수 있는 최대 점수, j번 열에서 뜯는 스티커는 i이다.
1. 뜯지 않는 경우
2. 위쪽 뜯는 경우
3. 아래쪽 뜯는 경우
*/

	public static void main(String[] args) throws java.lang.Exception {

        System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken()); 
        
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] map = new int[2][n+1];
            int[][] d = new int[3][n+1];

            for(int i = 0;i<2;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1;j<n+1;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 1;i<=n;i++) {
                d[0][i] = Math.max(d[0][i-1],Math.max(d[1][i-1],d[2][i-1])); //뜯지 않음
                d[1][i] = Math.max(d[0][i-1],d[2][i-1]) + map[0][i]; // 위쪽 뜯음
                d[2][i] = Math.max(d[0][i-1],d[1][i-1]) + map[1][i]; // 아래쪽 뜯음
                    
                
            }

        System.out.println(Math.max(d[0][n], Math.max(d[1][n], d[2][n])));
    

        }
    }
}