import java.io.*;
import java.util.*;

public class Main_BOJ_17086_아기상어2 {

	static int N, M;
	static int [][] map;
	static int [] dr = {-1,0,1,-1,1,-1,0,1};
	static int [] dc = {-1,-1,-1,0,0,1,1,1}; 
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		map = new int [N][M];
		Queue<Shark> que = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
				if(map[i][j] == 1) {
					que.offer(new Shark(i, j));
				}
			}
		}
		int answer = 0;
		while(!que.isEmpty()) {
			Shark s = que.poll();
			int r = s.r;
			int c = s.c;
			
			for(int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(!check(nr, nc)) continue;
				if(map[nr][nc] != 0) continue;
				
				map[nr][nc] = map[r][c] + 1;
				answer = Math.max(answer, map[nr][nc]);
				que.offer(new Shark(nr, nc));
			}
		}
		System.out.println(answer-1);
	}
	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
class Shark{
	int r;
	int c;
	public Shark(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}