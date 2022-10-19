import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static int[][] map, visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		for(int i = 0; i < N; i++) {
			char[] chars = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				map[i][j] = chars[j] - '0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		answer = Integer.MAX_VALUE;
		bfs(0, 0);
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}
	
	public static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c, 1, 0});
		visited[r][c] = 0;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int dist = pos[2];
			int cnt = pos[3];
			
			if(pos[0] == N-1 && pos[1] == M-1) {
				answer = dist;
				break;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = pos[0] + dr[d];
				int nc = pos[1] + dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				if(visited[nr][nc] <= cnt) continue; // 가려는 곳이 이미 벽이 뚫려있으면
				
				// 벽 아닐 때
				if(map[nr][nc] == 0) {
					visited[nr][nc] = cnt;
					queue.add(new int[] {nr, nc, dist+1, cnt});
				}
				// 벽 일 때 공사한 적이 없으면
				else if(map[nr][nc] == 1 && cnt == 0) {
					visited[nr][nc] = cnt+1;
					queue.add(new int[] {nr, nc, dist+1, cnt+1});
				}
			}
		}
	}
}
