import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, K;
	static int[][] map;
	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}

			int worm = 2;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						bfs(i, j, worm);
						worm++;
					}
				}
			}
			System.out.println(worm-2);
		}
	}
	
	public static void bfs(int r, int c, int g) {
		map[r][c] = g;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				if(map[nr][nc] == 1) {
					map[nr][nc] = g;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
	}
}
