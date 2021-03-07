import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Main {

    static int n;
    static int[] map;
    static int[] visited;
    static int[] s;
    
    static int ans;
	public static void main(String[] args) throws java.lang.Exception {

        System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken()); //가로
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            map = new int[n+1];
            visited = new int[n+1];
            s = new int[n+1];
            
            for(int i = 1;i<=n;i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            ans = 0;
            for(int i = 1;i<=n;i++) {
                if(visited[i] == 0) {
                    ans += solve(i,i,1);
                }
                
            }
            System.out.println(n-ans);
        }

        

    }

    static int solve(int v,int start,int cnt) {
        if(visited[v] != 0) {
            if(start != s[v]) {
                return 0;
            }
            return cnt - visited[v];
        }

        visited[v] = cnt;
        s[v] = start;

        return solve(map[v],start,cnt+1);
    }
}