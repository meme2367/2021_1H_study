import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {
//d[n][m] = 준규가 (N, M)으로 이동할 때, 가져올 수 있는 사탕 개수의 최댓값
	public static void main(String[] args) throws java.lang.Exception {

        System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] d = new int[n][m];

        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        d[0][0] = map[0][0];

        for (int i = 0; i< n; i++) {
            for (int j = 0; j< m; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }
                
                if(i == 0) {
                    d[i][j] = d[i][j-1] + map[i][j];
                    continue;
                }

                if(j == 0) {
                    d[i][j] = d[i-1][j] + map[i][j];
                    continue;    
                }

                d[i][j] = Math.max(d[i-1][j],Math.max(d[i][j-1],d[i-1][j-1]))+ map[i][j];
            }
        }

        System.out.println(d[n-1][m-1]);

    }
}