/* 11724. 연결 요소의 개수 */
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main
{
    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] ch;
    static int cnt;

    public static void main (String[] args) throws java.lang.Exception
    {
        
        System.setIn(new FileInputStream("input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ch = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0;i<n+1;i++) {
            arr.add(new ArrayList<Integer>());
        }
        

        for(int i = 0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(a).add(b);
            arr.get(b).add(a);
        }
    
        cnt = 0;
        ch[1] = true;
        dfs(1);

        System.out.println(cnt);
    
    }

    static void dfs(int l) {

        for(int i = 0;i<arr.get(l).size();i++) {
            if(!ch[arr.get(l).get(i)]) {
                ch[arr.get(l).get(i)] = true;
                cnt++;
                dfs(arr.get(l).get(i));

            }
        }
    }
}