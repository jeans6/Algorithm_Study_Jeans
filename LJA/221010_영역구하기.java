import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, K;
	static int[][] arr;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for(int y = y1; y < y2; y++) {
				for(int x = x1; x < x2; x++) {
					arr[y][x] = -1;
				}
			}
		}
		
		int g = 1;
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 0) {
					list.add(getGroup(g, i, j));
					g++;
				}
			}
		}
		Collections.sort(list);
		System.out.println(g-1);
		for(int i : list) System.out.print(i+" ");
	}
	
	public static int getGroup(int g, int r, int c) {
		int cnt = 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		arr[r][c] = g;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr<0 || nc<0 || nr>=M || nc >=N) continue;
				if(arr[nr][nc] != 0) continue;
				queue.offer(new int[] {nr, nc});
				arr[nr][nc] = g;
				cnt++;
			}
		}
		return cnt;
	}
}