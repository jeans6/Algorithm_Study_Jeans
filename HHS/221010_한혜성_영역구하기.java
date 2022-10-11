import java.io.*;
import java.util.*;

public class Main_BOJ_2583_영역구하기 {

	static int M, N, K;
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static int c;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		M = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < K; i++) {
			token = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(token.nextToken());
			int sy = Integer.parseInt(token.nextToken());
			int ex = Integer.parseInt(token.nextToken());
			int ey = Integer.parseInt(token.nextToken());
			for(int y = sy; y < ey; y++) {
				for(int x = sx; x < ex; x++)
					map[x][y] = 1;
			}
		}
		int cnt = 0;
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					visited[i][j] = true;
					c = 1;
					count(i, j);
					que.offer(c);
					cnt++;
				}
			}
		}
		
		bw.write(String.valueOf(cnt)+"\n");
		while(!que.isEmpty()) {
			bw.write(String.valueOf(que.poll())+" ");
		}
		bw.flush();
		bw.close();
	}

	private static void count(int x, int y) {
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(!check(nx, ny)) continue;
			if(map[nx][ny] != 0) continue;
			if(visited[nx][ny]) continue;
			
			visited[nx][ny] = true;
			c++;
			count(nx, ny);
			
		}
		
	}

	private static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

}
