
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{

	static int[] dx = {-1,-2,-1,-2,1,2,2,1};
	static int[] dy = {2,1,-2,-1,2,1,-1,-2};
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			int answer = 0;
			int l = Integer.parseInt(br.readLine()); // 체스판 크기 l*l
			int[][] ch = new int[l][l];
			int[][] map = new int[l][l];
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
				
			Queue<Node> q = new LinkedList<>();
			ch[b][c] = 1;
			q.add(new Node(b,c,0));
			//b,c -> d,e
			
			while(!q.isEmpty()){
				Node p = q.poll();
				
				if(p.x == d && p.y == e) {
					System.out.println(p.d);
					break;
				}
				for(int i = 0;i<8;i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					int nd = p.d;
					
					if(nx < 0 || ny < 0 || nx >= l || ny >= l) {
						continue;
					}
					
					if(ch[nx][ny] == 0) {
						ch[nx][ny] = 1;
						q.add(new Node(nx,ny,nd+1));
						
					}
					
				}
			}
	
			
		}
	
	}
		
	
}

class Node {
	int x;
	int y;
	int d;
	
	public Node(int x,int y,int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}