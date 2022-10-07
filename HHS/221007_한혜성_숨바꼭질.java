import java.io.*;
import java.util.*;

public class Main_BOJ_1697_숨바꼭질 {

	static int N, K;
	static int answer;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);

		boolean [] visited = new boolean[100001];
		
		visited[N] = true;
		Queue<int []> que = new LinkedList<>();
		que.offer(new int []{N, 0});
		
		while(!que.isEmpty()) {
			int [] q = que.poll();
			if(q[0] == K) {
				answer = q[1];
				break;
			}
			
			if(q[0]-1 >= 0 && !visited[q[0]-1]) {
				visited[q[0]-1] = true;
				que.offer(new int[] {q[0]-1, q[1]+1});
			}
			
			if(q[0]+1 <= 100000 && !visited[q[0]+1]) {				
				visited[q[0]+1] = true;
				que.offer(new int[] {q[0]+1, q[1]+1});
			}
			
			if(q[0]*2 <= 100000 && !visited[q[0]*2]) {
				visited[q[0]*2] = true;				
				que.offer(new int[] {q[0]*2, q[1]+1});
			}
			
		}
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		
	}

}
