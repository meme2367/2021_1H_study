import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.HashSet;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Solution sol  = new Solution();
        int[][] pud = {{2,2}};

        int ans = sol.solution(4,3,pud);
        System.out.println(ans);
    }
}

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] d = new int[n+1][m+1];
        
        for(int i = 0;i<puddles.length;i++) {
            d[puddles[i][1]][puddles[i][0]] = -1;
        }
        

        d[1][1] = 1;
        for(int i = 1;i<=n;i++) {
            for(int j = 1;j<=m;j++) {
                if(i == 1 && j == 1) {
                    continue;
                }
                if(d[i][j] == -1) {//웅덩이
                    d[i][j] = 0;
                    continue;
                }

                
                d[i][j] = (d[i][j-1] + d[i-1][j]) % 1000000007;
                
                
            }
        }
        
        
        return d[n][m];
    }
   
}