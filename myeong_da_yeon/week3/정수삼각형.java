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
        Solution sol  = new Solution();
        int[][] tr = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};

        int ans = sol.solution(tr);
        System.out.println(ans);
    }
}

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] d = new int[triangle.length][triangle.length];

        d[0][0] = triangle[0][0];
        

        for(int i = 1;i<triangle.length;i++) {
            for(int j = 0;j<triangle[i].length;j++) {
                if(j == 0) {//한 경로
                    d[i][j] = d[i-1][j]+triangle[i][j];
                } else if (i == j) {//한 경로
                    d[i][j] = d[i-1][j-1]+triangle[i][j];
                } else {//두 경로 중 큰 값
                    d[i][j] = Math.max(d[i-1][j-1]+triangle[i][j],d[i-1][j]+triangle[i][j]);
                }
                
            }
        }

        for(int i = 0;i<triangle[triangle.length-1].length;i++) {
            answer = Math.max(answer,d[triangle.length-1][i]);
        }

        return answer;
    }
}