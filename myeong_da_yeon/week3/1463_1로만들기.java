import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;

class Main
{
//d[n] = n를 1로 만들때의 최소 연산 횟수
//n이 3으로 나누어 떨어졌을 때, 3으로 나누는 경우  = d[n/3] + 1
//n이 2로 나누어 떨어졌을 때, 2로 나누는 경우 = d[n/2] + 1
//1을 빼는 경우 = d[n-1]+1
//min (위 세 경우)

    public static void main (String[] args) throws java.lang.Exception
    {
        
        System.setIn(new FileInputStream("input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] d = new int[n+1];

		d[0] = 0;
        d[1] = 0;

        for (int i=2; i<=n; i++) {
            d[i] = d[i-1] + 1;
            if (i%2 == 0 && d[i] > d[i/2] + 1) {
                d[i] = d[i/2] + 1;
            }

            if (i%3 == 0 && d[i] > d[i/3] + 1) {
                d[i] = d[i/3] + 1;
            }
        }

        System.out.println(d[n]);
	}
}