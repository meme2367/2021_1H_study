import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;

class Main
{
    
  
    static class Node {
        int zero;
        int first;

        public Node (int zero, int first) {
            this.zero = zero;
            this.first = first;
        }
    }


    static Node[] d = new Node[41];

    
    public static void main (String[] args) throws java.lang.Exception
    {
        
        System.setIn(new FileInputStream("input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
//d[i] = i번째 피보나치 수

        d[0] = new Node(1,0);
        d[1] = new Node(0,1);
        
        for(int i = 2;i<=40;i++) {
//            d[n] = d[n-1] + d[n-2];
            d[i] = new Node(d[i-1].zero + d[i-2].zero , d[i-1].first + d[i-2].first);
        }


        for(int i = 0;i<t;i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(d[n].zero + " " + d[n].first);
        }
        
        
    }

}
