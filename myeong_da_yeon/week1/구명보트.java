import java.util.*;
import java.util.Queue;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
      
        int[] people = {70,50,80,50};
        
        int limit = 100;
        Solution sol  = new Solution();
        int ans = sol.solution(people,limit);
        
            System.out.println(ans);
        
    }
}

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
       
        int start = 0;
        
        for (int end = people.length-1; start <= end ;end--) {
            if (people[start] + people[end] <= limit) {
                start++;
            }
            answer++;
        }
        
        return answer;
    }
}