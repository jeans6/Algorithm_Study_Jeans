import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S, answer;
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		for(int i = 0; i < S; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		answer = 0;
		visited[0] = true;
		dfs(0);
		System.out.println(answer);
	}
	
	public static void dfs(int start) {
		for(int i = 0; i < N; i++) {
			// 연결되어있고 방문한 적 X
			if(arr[start][i] == 1 && !visited[i]) {
				answer++;
				visited[i] = true;
				dfs(i);
			}
		}
	}
}
