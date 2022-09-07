import java.io.*;
import java.util.*;

public class Main_BOJ_1189_컴백홈 {

	static int R, C, K;
	static int answer;
	static char [][] map;
	static boolean [][] visited;
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		visited[R-1][0] = true;
		go(R-1, 0, 1);

		wr.write(String.valueOf(answer));
		wr.flush();
		wr.close();
	}
	private static void go(int r, int c, int count) {
		
		if(count == K && r == 0 && c == C-1) {
			answer++;
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!check(nr, nc)) continue;
			if(visited[nr][nc]) continue;
			if(map[nr][nc] == 'T') continue;
			
			visited[nr][nc] = true;
			go(nr, nc, count+1);
			
			visited[nr][nc] = false;
		}
		
		
	}
	private static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
