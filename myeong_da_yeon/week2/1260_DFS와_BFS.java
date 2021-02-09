import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;

class Main
{

   
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] ch;
    public static void main (String[] args) throws java.lang.Exception
    {
        
        System.setIn(new FileInputStream("input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        ch = new int[n+1];

        //인접리스트
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
        //이동경로가 작은 순
        for(int i = 0;i<arr.size();i++) {
            Collections.sort(arr.get(i));
        }

        //dfs
        dfs(v);
        System.out.print("\n");
        //bfs
        
        ch = new int[n+1];
        bfs(v);
    }

    static void dfs(int v) {
        System.out.print(v + " ");
        ch[v] = 1;
        for(int i = 0;i<arr.get(v).size();i++) {
            if(ch[arr.get(v).get(i)] == 0) {
                dfs(arr.get(v).get(i));
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        ch[v] = 1;
        q.add(v);
        while(!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");
            for(int i = 0;i<arr.get(x).size();i++) {
                if(ch[arr.get(x).get(i)] == 0) {
                    ch[arr.get(x).get(i)] = 1;
                    q.add(arr.get(x).get(i));
                }
            }
        }
    }
}