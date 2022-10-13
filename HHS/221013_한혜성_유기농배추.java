import java.io.*;
import java.util.*;

public class Main_BOJ_1012_유기농배추 {

	static int T;
	static int N, M, K;
	static int answer;
	static int [][] map;
	static boolean [][] visited;
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = null; 
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			
			answer = 0;
			token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			K = Integer.parseInt(token.nextToken());
	
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int k = 0; k < K; k++) {
				token = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(token.nextToken());
				int c = Integer.parseInt(token.nextToken());
				map[r][c] = 1;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						dfs(i, j);
						answer++;
					}
				}
			}
			
			bw.write(String.valueOf(answer)+"\n");
		}
		bw.close();
		
	}

	private static void dfs(int r, int c) {
		for(int d = 0; d < 4; d++) {
			int nr = dr[d] + r;
			int nc = dc[d] + c;
			
			if(!check(nr, nc)) continue;
			if(visited[nr][nc]) continue;
			if(map[nr][nc] != 1) continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc);
		}
		
		
	}
	
	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
