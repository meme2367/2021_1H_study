import java.util.*;

class Solution {
    
    static boolean[] check;
   
    static ArrayList<String> arr = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        String ans = "";
        check = new boolean[tickets.length];
        
        ans += "ICN,";
        for(int i = 0;i<tickets.length;i++) {
            //ICN정점부터 시작
            
            if(tickets[i][0].equals("ICN") && !check[i]) {
                ans+=(tickets[i][1]+",");
                
                check[i] = true;
                dfs(tickets[i][1],1,tickets,ans);
                check[i] = false;
                ans = ans.substring(0,ans.length()-4);
                 
            }
        }
        
        Collections.sort(arr);
        
        String[] answer = arr.get(0).split(",");
        
        return answer;
    }
    static void dfs(String v, int cnt,String[][] tickets,String ans) {
        
        if(cnt == tickets.length) {
            
            arr.add(ans);
            return;
        } 
        
        for(int i = 0;i<tickets.length;i++) {
            if(tickets[i][0].equals(v) && !check[i]) {
                
                ans += (tickets[i][1]+",");
                check[i] = true;
                dfs(tickets[i][1],cnt+1,tickets,ans);
                check[i] = false;
                ans = ans.substring(0,ans.length()-4);
            }
        }
    }
}