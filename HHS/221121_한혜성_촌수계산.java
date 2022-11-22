import java.io.*;
import java.util.*;

public class Main_BOJ_2644_촌수계산 {

	static int N;
	static int S, E;
	static int T;
	static int answer;
	static int [] arr;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		S = Integer.parseInt(token.nextToken());
		E = Integer.parseInt(token.nextToken());
		arr = new int [N+1];
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			token = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(token.nextToken());
			int c = Integer.parseInt(token.nextToken());
			
			arr[c] = p;
		}
		
		Queue<int []> que = new LinkedList<>();
		int [] visited = new int [N+1];
		Arrays.fill(visited, -1);
		que.offer(new int[] {S, 0});
		que.offer(new int[] {E, 0});
		visited[S] = 0;
		visited[E] = 0;
		
		while(!que.isEmpty()) {
			int [] q = que.poll();
			int num = q[0];
			int cnt = q[1];
			
			if(arr[num] != 0 && visited[arr[num]] != -1) {
				answer = cnt + visited[arr[num]] + 1;
				break;
			}
			if(arr[num] != 0) {
				que.offer(new int[] {arr[num], cnt + 1});
				visited[arr[num]] = cnt+1;				
			}
			
		}
		if(answer == 0) answer = -1;
		
		bw.write(String.valueOf(answer));
		bw.close();
	}

}
