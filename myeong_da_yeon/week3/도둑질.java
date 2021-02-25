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
        int[] money = {1,2,3,1};
        int ans = sol.solution(money);
        System.out.println(ans);
    }
}

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] d = new int[money.length];
        int[] d2 = new int[money.length];
        
        d[0] = money[0];
        d[1] = d[0];

        for(int i = 2;i<d.length-1;i++) {
            d[i] = Math.max(d[i-2]+money[i],d[i-1]);
        }

        d2[0] = 0;
        d2[1] = money[1];

        for(int i = 2;i<d2.length;i++) {
            d2[i] = Math.max(d2[i-2]+money[i],d2[i-1]);
        }

        return Math.max(d[d.length-2],d2[d2.length-1]);
    }
}
