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
        int ans = sol.solution(2,11);
        System.out.println(ans);
    }
}

class Solution {
    static int n;
    static int target;
    static int ans = 217000000;

    public int solution(int N, int number) {
        n = N;
        target = number;
        solve(0,0);
        return ans > 8 ? -1 : ans;
    }

    void solve(int cnt,int num) {

        if(cnt > 8) {
            return;
        }

        if(target == num) {
            ans = Math.min(ans,cnt);
            return;
        }

        for(int i = 1;i<=8-cnt;i++) {
            solve(cnt+i,num+makeNum(i,n));
            solve(cnt+i,num-makeNum(i,n));
            solve(cnt+i,num*makeNum(i,n));
            solve(cnt+i,num/makeNum(i,n));
        }

    }

    int makeNum(int zari,int n) {
        int res = 0;
        while(zari-- > 0){
            res = res * 10 + n;
        }
        return res;
    }


}