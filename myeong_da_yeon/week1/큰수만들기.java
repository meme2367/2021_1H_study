import java.util.*;
import java.util.Queue;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
      
       
        Solution sol  = new Solution();
        String ans = sol.solution("1924",2);
        
        System.out.println(ans);
        
    }
}

class Solution {
    
    public String solution(String number, int k) {
        
        Stack<Character> s = new Stack<Character>();
        int tmpk = k;
        
        for (int i = 0;i< number.length();i++) {
            char ch = number.charAt(i);
        
            while ( !s.isEmpty() && ch > s.peek() && k > 0) {
                s.pop();
                k--;
            }
            s.push(ch);
        }    

        StringBuilder sb = new StringBuilder();


        for (int i = 0;i<number.length()-tmpk;i++) {
            sb.append(s.get(i));
        }

        return String.valueOf(sb);
    }
    
    
}