import java.io.*;
import java.util.*;

public class Main_BOJ_2206_벽부수고이동하기 {

	static int N, M;
	static int [][] map;
	static int answer;
	static boolean [][][] visited;
	static int []dr = {-1,0,1,0};
	static int []dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer token = null; 
		token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for(int i = 0; i < N; i++) {
			String [] str = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		bfs();
		if(answer == 0)
			answer = -1;
		bw.write(String.valueOf(answer));
		bw.close();
	}

	private static void bfs() {

		Queue<Wall> que = new LinkedList<>();
		//0이면 벽 부순 전적 있는 상태로 방문한 것
		//1이면 벽 안 부셔본 상태로 방문한 것
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		que.offer(new Wall(0,0,1,false));
		
		while(!que.isEmpty()) {
			Wall w = que.poll();
			if(w.r == N-1 && w.c == M-1) {
				answer = w.count;
				break;
			}
			for(int d = 0; d < 4; d++) {
				int nr = dr[d]+ w.r;
				int nc = dc[d]+ w.c;
				if(!check(nr, nc)) continue;
				int v = 1;
				if(w.check) v = 0;
				if(visited[nr][nc][v]) continue;
				if(map[nr][nc] == 0) {
					visited[nr][nc][v] = true;
					que.offer(new Wall(nr, nc, w.count+1, w.check));
				}
				if(map[nr][nc] == 1 && w.check == false) {
					visited[nr][nc][1] = true;
					que.offer(new Wall(nr, nc, w.count+1, true));
				}
			}
			
			
		}
		
		
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
class Wall{
	int r;
	int c;
	int count;
	boolean check;
	public Wall(int r, int c, int count, boolean check) {
		super();
		this.r = r;
		this.c = c;
		this.count = count;
		this.check = check;
	}
}