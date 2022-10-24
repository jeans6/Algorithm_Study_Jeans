import java.io.*;
import java.util.*;

public class Main_BOJ_DSLR {

	static int T;
	static int A, B;
	static String answer;
	static boolean [] visited;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = null;
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			token = new StringTokenizer(br.readLine());
			A = Integer.parseInt(token.nextToken());
			B = Integer.parseInt(token.nextToken());
			answer = "";
			visited = new boolean [10000];
			bfs();
			
			bw.write(answer+"\n");
		
		}
		bw.close();
		
	}

	private static void bfs() {

		Queue<Cal> que = new LinkedList<>();
		visited[A] = true;
		que.offer(new Cal(A, ""));
		
		while(!que.isEmpty()) {
			Cal c = que.poll();
		
			if(c.num == B) {
				answer = c.ans;
				break;
			}
			
			//D
			int temp = (c.num * 2) % 10000;
			if(!visited[temp]) {
				visited[temp] = true;
				que.offer(new Cal(temp,c.ans+"D"));
			}
			
			//S
			temp = (c.num == 0 ? 9999 : c.num-1);
			if(!visited[temp]) {
				visited[temp] = true;
				que.offer(new Cal(temp, c.ans+"S"));
			}
			
			
			//L
			int mod = c.num % 1000;
			int div = c.num / 1000;
			temp = mod*10 + div;
			if(!visited[temp]) {
				visited[temp] = true;
				que.offer(new Cal(temp, c.ans+"L"));
			}
			
			//R
			mod = c.num % 10;
			div = c.num / 10;
			temp = mod*1000 + div;
			if(!visited[temp]) {
				visited[temp] = true;
				que.offer(new Cal(temp, c.ans+"R"));
			}
		}
		
	}

}
class Cal{
	int num;
	String ans;
	public Cal(int num, String ans) {
		super();
		this.num = num;
		this.ans = ans;
	}
}