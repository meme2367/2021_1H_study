import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {
//d[n] = 2*n을 채우는 방법의 수
	public static void main(String[] args) throws java.lang.Exception {

        System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int[] d  = new int[1001];
        int n = Integer.parseInt(st.nextToken()); //세로
        
        d[0] = 0;
        d[1] = 1;
        d[2] = 2;

        for(int i = 3;i<=n;i++) {
            d[i] = (d[i-1]+d[i-2]) % 10007;
        }

        System.out.println(d[n]);

    }
}