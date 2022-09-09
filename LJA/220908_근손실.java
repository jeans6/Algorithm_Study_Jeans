import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] kit;
	static int N, K, answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		kit = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		
		// 순열
		answer = 0;
		perm(0, new boolean[N], new int[N]);
		System.out.println(answer);
	}
	
	public static void perm(int cnt, boolean[] visited, int[] arr) {
		if(cnt == N) {
			int total = 500;
			for(int i = 0; i < N; i++) {
				if(total + arr[i] - K < 500) return;
				total += arr[i] - K;
			}
			answer++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			arr[cnt] = kit[i];
			perm(cnt+1, visited, arr);
			visited[i] = false;
		}
	}
}