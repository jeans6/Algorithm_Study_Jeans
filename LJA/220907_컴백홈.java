import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static boolean[][] visited;
	public static int R, C, K, answer;
	// 상우하좌
	public static int[] dr = {-1, 0, 1, 0};
	public static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			char[] charArr = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				if(charArr[j] == 'T') visited[i][j] = true;
			}
		}
		visited[R-1][0] = true;
		dfs(R-1, 0, 1);
		System.out.println(answer);
	}
	
	public static void dfs(int r, int c, int cnt) {
		if(cnt > K) return;
		if(r == 0 && c == C-1) {
			if(cnt == K) answer++;
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
			if(visited[nr][nc]) continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc, cnt+1);
			visited[nr][nc] = false;
		}
	}
}