import java.io.*;
import java.util.*;

public class Main_BOJ_1600_말이되고픈원숭이 {

	static int K;
	static int N, M;
	static int [][] map;
	static boolean [][][] visited;
	static int answer;
	static int [] hr = {-1,-2,-2,-1,1,2,1,2};
	static int [] hc = {-2,-1,1,2,-2,-1,2,1};
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer token;
		
		token = new StringTokenizer(br.readLine());
		M = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][K+1];
		for(int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		answer = Integer.MAX_VALUE;
		
		bfs();
		
		if(answer == Integer.MAX_VALUE)
			answer = -1;
		
		bw.write(String.valueOf(answer));
		bw.close();
	}

	private static void bfs() {

		Queue<Horse> que = new LinkedList<>();
		que.offer(new Horse(0,0,0,0));
		visited[0][0][0] = true;
		
		while(!que.isEmpty()) {
			Horse h = que.poll();
			
			if(h.r == N-1 && h.c == M-1) {
				answer = h.count;
				break;
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = h.r + dr[d];
				int nc = h.c + dc[d];
				if(!check(nr, nc)) continue;
				if(map[nr][nc] == 1) continue;
				
				if(visited[nr][nc][h.k]) continue;
				visited[nr][nc][h.k] = true;
				que.offer(new Horse(nr, nc, h.count+1, h.k));							
			}
		
			if(h.k < K) {
				for(int d = 0; d < 8; d++) {
					int nr = h.r + hr[d];
					int nc = h.c + hc[d];
					if(!check(nr, nc)) continue;
					if(map[nr][nc] == 1) continue;
					
					if(!visited[nr][nc][h.k+1]) {
						visited[nr][nc][h.k+1] = true;
						que.offer(new Horse(nr, nc, h.count+1, h.k+1));						
					}
				}
			}
			
		}
		
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
class Horse{
	int r;
	int c;
	int count;
	int k;
	public Horse(int r, int c, int count, int k ) {
		super();
		this.r = r;
		this.c = c;
		this.count = count;
		this.k = k;
	}
}
