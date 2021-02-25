import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        
        System.setIn(new FileInputStream("input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

       int n = Integer.parseInt(st.nextToken());
       int[][] d = new int[n][n];
       int[][] triangle = new int[n][n];

       for(int i = 0;i<n;i++) {
           st = new StringTokenizer(br.readLine());
           for(int j = 0;j<i+1;j++) {
               triangle[i][j] = Integer.parseInt(st.nextToken());
           }
       }

        d[0][0] = triangle[0][0];
        

        for(int i = 1;i<triangle.length;i++) {
            for(int j = 0;j<triangle[i].length;j++) {
                if(j == 0) {//한 경로
                    d[i][j] = d[i-1][j]+triangle[i][j];
                } else if (i == j) {//한 경로
                    d[i][j] = d[i-1][j-1]+triangle[i][j];
                } else {//두 경로 중 큰 값
                    d[i][j] = Math.max(d[i-1][j-1]+triangle[i][j],d[i-1][j]+triangle[i][j]);
                }
                
            }
        }

        int answer = 0;

        for(int i = 0;i<triangle[triangle.length-1].length;i++) {
            answer = Math.max(answer,d[triangle.length-1][i]);
        }
        System.out.println(answer);
    }
}