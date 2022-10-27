import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i = 0; i < N; i++) arr[i][i] = 1;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		int g = 2;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 1) {
					dfs(i, j, g);
					g++;
				}
			}
		}
		
		System.out.println(g-2);
	}
	
	public static void dfs(int r, int c, int g) {
		arr[r][c] = g;
		for(int j = 0; j < N; j++) {
			if(arr[c][j] == 1) {
				dfs(c, j, g);
			}
		}
	}
	
}
