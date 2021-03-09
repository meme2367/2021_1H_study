import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {
/*
1 <= n <= 1000
- 완전탐색?
n! > 1억(1초)
- 그리디? 
10 20 10 30 20 50 의 경우
20 10 은 가능하지만 뒤에 10보다 큰 값이 올 수 있다.
미래의 값을 신경써야 하기 때문에 그리디 아님
그리디는 항상 현재가 최적의 해를 만족해야함.
: dp
이전 값을 활용할 수 있고, 그리디도 안되고 봐야될 게 많음

d[i] 
= a[1] ,,, a[i] 까지 수열이 있을 때 
a[i]를 마지막으로 하는 가장 긴 증가하는 부분수열의 길이

 */
	public static void main(String[] args) throws java.lang.Exception {

        System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //가로
        
        int[] a = new int[10001];
        int[] d = new int[10001];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 1;i<=n;i++) { // i : 1 ~ n
            d[i] = 1;
            for(int j = 1; j < i ; j++ ) { //j : 1 ~ i-1
                if(a[j] < a[i]) {
                   d[i] = Math.max(d[i],d[j]+1);
                }
            }

           ans =  Math.max(d[i],ans);
        }

        
        System.out.println(ans);

    }
}