import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;

class Main
{
/*
* d[i][j] = i번째 계단에 올라갔을 때 최대 점수. i번째 계단은 j개 연속해서 올라온 상태
* d[i][1] = 1개 연속 = max(d[i-2][1],d[i-2][2]) + a[i]
* d[i][2] = 2개 연속 = i-1번째까지 1개연속해서 올라와야함
* = d[i-1][1] + a[i]
*/
    public static void main (String[] args) throws java.lang.Exception
    {
        
        System.setIn(new FileInputStream("input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        
        int[] a = new int[n+1];
        for(int i = 1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] d = new int[n+1][3];
        //d[0][1] = 0;
        //d[0][2] = 0;
        d[1][1] = a[1];
        //d[1][2] = 0;

        for(int i = 2;i<=n;i++) {
            d[i][1] = Math.max(d[i-2][1],d[i-2][2]) + a[i];
            d[i][2] = d[i-1][1] + a[i];
        }

        System.out.println(Math.max(d[n][1],d[n][2]));

        

	}
}