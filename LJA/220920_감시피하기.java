import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int N;
	static boolean isHide;
	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().replaceAll(" ", "").toCharArray();
		}
		
		// 폭탄이 설치될 수 있는 곳 체크(선생님과 학생 마주 보는 곳)
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'T') hide(i, j);
			}
		}
		
		// 폭탄 3개 설치하고 찾을 수 있는지 확인
		isHide = false;
		dfs(0, 0, 0, new boolean[N][N]);
		
		System.out.println(isHide?"YES":"NO");
	}
	
	public static void hide(int r, int c) {
		// 선생님 기준 사방 체크 후 학생이 있으면
		// 선생님과 학생 사이 거리를 다 1로 채움(장애물이 설치 될 곳)
		for(int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			boolean isStudent = false;
			while(true) {
				nr += dr[d];
				nc += dc[d];
				if(nr<0 || nc<0 || nr>=N || nc>=N) break;
				if(map[nr][nc] == 'S') {
					isStudent = true;
					break;
				}
			}
			
			if(isStudent) {
				nr = r;
				nc = c;
				while(true) {
					nr += dr[d];
					nc += dc[d];
					if(nr<0 || nc<0 || nr>=N || nc>=N) break;
					if(map[nr][nc] == 'S') break;
					map[nr][nc] = '1';
				}
			}
		}
	}
	
	public static boolean seek() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'T') {
					for(int d = 0; d < 4; d++) {
						int nr = i;
						int nc = j;
						while(true) {
							nr += dr[d];
							nc += dc[d];
							if(nr<0 || nc<0 || nr>=N || nc>=N) break;
							if(map[nr][nc] == 'O') break;
							if(map[nr][nc] == 'S') return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static void dfs(int r, int c, int cnt, boolean[][] visited) {
		if(cnt == 3) {
			if(!seek()) isHide = true;
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
			if(visited[nr][nc]) continue;
			visited[nr][nc] = true;
			if(map[nr][nc] == '1') {
				map[nr][nc] = 'O';
				dfs(nr, nc, cnt+1, visited);
				map[nr][nc] = '1';
			} else {
				dfs(nr, nc, cnt, visited);
			}
			visited[nr][nc] = false;
		}
	}
}
