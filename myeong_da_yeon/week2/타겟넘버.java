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
      
        int[] numbers = {1,1,1,1,1};
        
        Solution sol  = new Solution();
        int ans = sol.solution(numbers,3);
        System.out.println(ans);
    }
}

class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(0,0,numbers,target);

        return answer;
    }

    static void dfs(int idx, int sum,int[] numbers,int target) {
        if(idx == numbers.length) {

            if(sum == target) {
                answer++;
            }
            return;
        }

        dfs(idx+1,sum + numbers[idx], numbers,target);

        dfs(idx+1,sum - numbers[idx], numbers,target);
    }        
}
