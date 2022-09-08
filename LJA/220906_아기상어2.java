import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[][] map, safe;
	public static boolean[][] visited;
	public static int N, M, answer;
	// 8방향
	public static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	public static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		safe = new int[N][M];
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) queue.offer(new int[] {i, j});
			}
		}
		
		int answer = 0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			
			for(int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(map[nr][nc] == 1 || safe[nr][nc] != 0) continue;
				safe[nr][nc] = safe[r][c]+1;
				answer = Math.max(answer, safe[nr][nc]);
				queue.offer(new int[] {nr, nc});
			}
		}
		System.out.println(answer);
	}
}