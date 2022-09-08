import java.io.*;
import java.util.*;

public class Main_BOJ_18429_근손실 {

	static int N, K;
	static int [] power;
	static int answer;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		
		power = new int[N];
		token = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			power[i] = Integer.parseInt(token.nextToken());
		}

		find(0, 500-K, new int[N], new boolean[N]);
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		
	}

	private static void find(int cnt, int hp, int[] nums, boolean[] visited) {
		if(cnt == N) {
			answer++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i])
				continue;
			if(hp + power[i] < 500)
				continue;
			
			visited[i] = true;
			find(cnt+1, hp+power[i]-K, nums, visited);
			visited[i] = false;
		}
	}
	
}
