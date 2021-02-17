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
      
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        Solution sol  = new Solution();
        int ans = sol.solution(begin,target,words);
        System.out.println(ans);
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Point> q = new LinkedList<>();
        HashMap<String,Integer> hm = new HashMap<>();
        
        hm.put(begin,1);
        q.add(new Point(begin,0));
        
        while(!q.isEmpty()) {
            Point p = q.poll();
           
            
            if(target.equals(p.str)) {
                answer = p.cnt;
                break;
            }
            
            for(int i = 0;i<words.length;i++) {
                
                if(hm.get(words[i]) == null && check(p.str, words[i])) {
                    hm.put(words[i],1);
                    q.add(new Point(words[i],p.cnt+1));
                    
                }
            }
            
        }
        
        
        return answer;
    }
    
    boolean check(String str, String qStr) {
        
        int cnt = 0;
        for(int i = 0;i<str.length();i++) {
            
            if(str.charAt(i) != qStr.charAt(i)) {
                cnt++;
            }
        }
        
        if(cnt == 1) {
          return true;  
        } 
        
        return false;
    }
}
class Point {
    String str;
    int cnt;
    
    public Point(String str,int cnt) {
        this.str = str;
        this.cnt = cnt;
    }
}