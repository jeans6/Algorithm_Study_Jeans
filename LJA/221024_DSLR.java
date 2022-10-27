import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			bfs(start, end, new boolean[10000]);
		}
	}
	
	public static void bfs(int start, int end, boolean[] visited) {
		Queue<Register> queue = new LinkedList<>();
		visited[start] = true;
		queue.offer(new Register(start, ""));
		
		while(!queue.isEmpty()) {
			Register cur = queue.poll();
			if(cur.n == end) {
				System.out.println(cur.str);
				return;
			}
			int n = cur.n;
			
			int temp = (n*2)%10000;
			if(!visited[temp]) {
				visited[temp] = true;
				queue.offer(new Register(temp, cur.str+"D"));
			}
			
			temp = (n==0?9999:n-1);
			if(!visited[temp]) {
				visited[temp] = true;
				queue.offer(new Register(temp, cur.str+"S"));
			}
			
			temp = (n%1000)*10 + n/1000;
			if(!visited[temp]) {
				visited[temp] = true;
				queue.offer(new Register(temp, cur.str+"L"));
			}
			
			temp = n/10 + (n%10)*1000;
			if(!visited[temp]) {
				visited[temp] = true;
				queue.offer(new Register(temp, cur.str+"R"));
			}
		}
	}
	
	public static class Register {
		int n;
		String str;
		
		Register(int n, String str) {
			this.n = n;
			this.str = str;
		}
	}
}
