import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {
//d[i][j] = i자리, 마지막 수 j 일 때 오르막 수 개수

    static final int MOD = 10007;

	public static void main(String[] args) throws java.lang.Exception {

        System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] d = new int[1001][11];

        for (int i = 0; i<=9; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i<=n; i++) {
            for (int k = 0; k<=9 ;k++) {
                for (int j = 0; j<=k ; j++) {
                    d[i][k] += d[i-1][j];
                    d[i][k] %= MOD;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i< 10 ; i++) {
            ans += d[n][i];
        }

        System.out.println(ans%MOD);
    }
}