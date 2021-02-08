import java.util.*;
import java.util.Queue;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
      
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        int n = 5;

        Solution sol  = new Solution();
        int ans = sol.solution(n,lost,reserve);
        System.out.println(ans);
        
    }
}
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] ch = new int[n+1];
        
        int bothExistCnt = 0;
        int cnt = 0;
        
        for (int j = 0;j<lost.length;j++) {
            for (int i = 0;i<reserve.length;i++) {
                if (lost[j]==reserve[i]) {
                    bothExistCnt++;
                    lost[j] = -1;
                    reserve[i] = -1;
                    break;
                }
            }
         }

        for (int j = 0;j<lost.length;j++) {
            for (int i = 0;i<reserve.length;i++) {
                if (lost[j] == reserve[i]-1 || lost[j] == reserve[i]+1 ) {
                    reserve[i] = -1;
                    cnt++;
                    break;
                }
            }
        }



        answer = n - lost.length + bothExistCnt + cnt;
        return answer;
    }
}