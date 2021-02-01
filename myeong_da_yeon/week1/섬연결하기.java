import java.util.*;

class Solution {
    
    static int[] unf;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        ArrayList<Point> p = new ArrayList<>();
        
        unf = new int[n];
        
        for (int i = 0 ; i< costs.length;i++) {
            p.add(new Point(costs[i][0], costs[i][1], costs[i][2]));     
        }
        
        for(int i = 0;i<n;i++) {
            unf[i] = i;
        } 
        
        
         p.sort((p1,p2) -> p1.c - p2.c);      
        
        for(int i = 0 ;i<p.size();i++) {
            int x = find(p.get(i).x);
            int y = find(p.get(i).y);
            int c = p.get(i).c;
            
            if (x != y) {
                union(x,y);
                answer += c;
            }
            
        }
        
        
        return answer;
    }
    
    static int find(int v) {
        if(v == unf[v]) {
            return v;
        }
        
        return unf[v] = find(unf[v]);
    }
    
    static void union(int s,int e) {
        int x = find(s);
        int y = find(e);
        
        if(x != y) {
            unf[x] = y;
        }
    }
    
    
}

class Point {
    int x;
    int y;
    int c;
    
    public Point(int x,int y,int c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }
    
}