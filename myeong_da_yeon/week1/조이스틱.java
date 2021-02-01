import java.util.*;

class Solution {
    public int solution(String name) {

        int answer = 0;

        StringBuilder nameBuilder = new StringBuilder(name);
        StringBuilder tmpBuilder = new StringBuilder("");

        
        for (int i = 0; i < name.length() ; i++) {
            tmpBuilder.append('A');
        }
        
        int now = 0;

        while(true) {

            int left  = now;
            int right = now;

            if (nameBuilder.charAt(now) != 'A') {
                answer += Math.min(nameBuilder.charAt(now)-'A', 'Z'-nameBuilder.charAt(now)+1);
                nameBuilder.setCharAt(now,'A');
            }

            
            if (tmpBuilder.toString().equals(nameBuilder.toString())) break;
            int moveCnt = 0;

            while(true) {

                left--;
                right++;
                moveCnt++;
                if (left < 0) { 
                    left = nameBuilder.length()-1;
                }
                
                if (right == nameBuilder.length()) {
                    right = 0;
                }
                
                if (nameBuilder.charAt(right) != 'A') {
                    answer += moveCnt;
                    now = right;
                    break;
                }

                
                if (nameBuilder.charAt(left) != 'A') {
                    answer += moveCnt;
                    now = left;
                    break;
                }
            }
        }
        return answer;
    }

}