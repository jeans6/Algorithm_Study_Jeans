import java.io.*;
import java.util.*;

public class Main_BOJ_2606_바이러스 {

	static int N;
	static int K;
	static int answer;
	static boolean [] visited;
	static ArrayList<int []> virus;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		StringTokenizer token = null;
		visited = new boolean[N+1];
		virus = new ArrayList<>();
		
		for(int k = 0; k < K; k++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());

			virus.add(new int[] {start, end});
		}
		
		bfs();
		
		bw.write(String.valueOf(answer));
		bw.close();
	}
	
	private static void bfs() {
		
		Queue<Integer> que = new LinkedList<>();
		que.offer(1);
		visited[1] = true;
		answer = -1;
		while(!que.isEmpty()) {
			answer++;
			int q = que.poll();
			
			for(int i = 0; i < virus.size(); i++) {
				if(virus.get(i)[0] == q && !visited[virus.get(i)[1]]) {
					visited[virus.get(i)[1]] = true;
					que.offer(virus.get(i)[1]);
				}
				else if(virus.get(i)[1] == q && !visited[virus.get(i)[0]]) {
					visited[virus.get(i)[0]] = true;
					que.offer(virus.get(i)[0]);
				}
			}
			
		}
		
	}
}
