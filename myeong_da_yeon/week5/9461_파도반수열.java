import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {
//d[i] = d[i-1] + d[i-5]
//d[i] = d[i-2] + d[i-3]
    public static void main(String args[]) throws java.lang.Exception {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        long[] d = {0,1,1,1,2,2,3,4,5,7,9};
        d = Arrays.copyOf(d, 101);
        for (int i=11; i<=100; i++) {
            d[i] = d[i-1] + d[i-5];
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }
}