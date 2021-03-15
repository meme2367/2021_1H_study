import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {
//펠린드롬 = 순회
//d[i][j] = a[i] ~ a[j]가 팰린드롬이면 2 아니면 1

    static int[][] d;
    static int[] a;
	public static void main(String[] args) throws java.lang.Exception {

        System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //가로
        
        a = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        d = new int[n+1][n+1];

    
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (solve(s,e) == 2) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.println(sb.toString());
    }

    static int solve(int i,int j) {
        if (i == j) {   // 길이 1일 때는 무조건 팰린드롬
            return 2;
        }

        if (j-i+1 == 2) { // 길이 2일 때는 앞 뒤 글자가 같아야지만 팰린드롬
            if (a[i] == a[j]) {
                return 2;
            } else {
                return 1;
            }
        }

        if(d[i][j] >= 1) { //메모제이션 한 게 있으면
            return d[i][j];
        }

        //길이 3이상일 때는 맨 앞 글자와 맨 뒤 글자가 같아야하고 그 안 글자가 팰린드롬이어야함.
        if(a[i] == a[j]) {
            return d[i][j] = solve(i+1,j-1);//메모제이션
        } else {
            return 0;
        }
    }
}