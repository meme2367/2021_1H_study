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
      
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        int n = 3;
        Solution sol  = new Solution();
        int ans = sol.solution(n, computers);
        System.out.println(ans);
    }
}

class Solution {
    
    static int[] tmp;
    
    public int solution(int n, int[][] computers) {
        tmp = new int[computers.length];
        
        for(int i = 0;i<tmp.length;i++) {
            tmp[i]  = i;    
        }
        
        for(int i = 0;i<computers.length;i++) {
            for(int j = 0;j<computers[i].length;j++) {
                if(computers[i][j] == 1) {
                    if(i == j) {
                        continue;
                    } else {
                    
                        union(i,j);
                    }
                
                }
            }
        }
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0;i<tmp.length;i++) {
                hs.add(find(i));
        }
        
        return hs.size();
    }
    
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
    
        if(x != y) {
            tmp[x] = y;
        }
    }
    
    static int find(int v) {
        if(v == tmp[v]) {
            return v;
        } else {
            return find(tmp[v]);
        }
    }
}
