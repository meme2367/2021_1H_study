import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (o1,o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        
        int tmp = routes[0][1];
        
        for(int i = 0;i<routes.length-1;i++) {
            if(tmp > routes[i][1]) {
                tmp = routes[i][1];
            }
            if(routes[i+1][0] > tmp) {
                answer++;
                tmp = routes[i+1][1];
            }
        }
        
        return answer;
    }
}