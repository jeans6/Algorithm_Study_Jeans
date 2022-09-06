import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int R, C, N;
	public static int[][] map;
	
	public static void main(String[] args) throws Exception {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		// 폭탄이 터지게 될 시간으로 폭탄이 어딨는지 체크
		map = new int[R][C];
		for(int i = 0; i < R; i++) {
			char[] charArr = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				if(charArr[j] == 'O') map[i][j] = 3;
			}
		}
		
		// 0초에 기본 폭탄이 놓여지고
		// 1초에 아무것도 안하므로 2초부터 시작
		// 짝수초엔 폭탄 놓고 홀수초엔 폭탄이 터짐
		for(int i = 2; i <= N; i++) {
			if(i%2 == 0) setBomb(i);
			else bomb(i);
		}
		print();
	}
	
	// time+3에 폭탄이 터지도록 설치
	public static void setBomb(int time) {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 0) map[i][j] = time+3;
			}
		}
	}
	
	// 현재 time과 같은 폭탄은 모두 터지는데 동시에 터져야 하므로 explode라는 배열 사용
	public static void bomb(int time) {
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		boolean[][] explode = new boolean[R][C];
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == time) {
					explode[r][c] = true;
					for(int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
						explode[nr][nc] = true;
					}
				}
			}
		}

		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(explode[r][c]) map[r][c] = 0;
			}
		}
	}
	
	public static void print() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 0) System.out.print(".");
				else System.out.print("O");
			}
			System.out.println();
		}
	}
}