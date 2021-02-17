
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {
    static int N;
    static int K;
    static int[] check = new int[100001];

    public static void main(String[] args) {
        
       // System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        check[num] = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();

            if (temp == K) {
                System.out.println(check[temp]);
                return;
            }
            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                

                if (next >= 0 && next < check.length && check[next] == 0) {
                    q.add(next);
                    check[next] = check[temp] + 1;
                }
            }
        }
    }
}