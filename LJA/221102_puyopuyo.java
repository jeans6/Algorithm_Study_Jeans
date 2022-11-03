import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N = 12, M = 6, answer;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] board;
	static List<int[]> list;
	static List<int[]> popList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new char[N][M];
		for(int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		answer = 0;
		popList = new ArrayList<>();
		boolean isEnd = false;
		while(!isEnd) {
			boolean[][] visited = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(board[i][j] != '.' && !visited[i][j]) {
						list = new ArrayList<>();
						visited[i][j] = true;
						list.add(new int[] {i, j});
						puyo(i, j, board[i][j], visited);
						
						if(list.size() >= 4) popList.addAll(list);
						list.removeAll(list);
					}
				}
			}
			
			if(popList.size() > 0) pop();
			else isEnd = true;
		}
		System.out.println(answer);
	}
	
	public static void puyo(int r, int c, char ch, boolean[][] visited) {	
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
			if(!visited[nr][nc] && board[nr][nc] == ch) {
				visited[nr][nc] = true;
				list.add(new int[] {nr, nc});
				puyo(nr, nc, ch, visited);
			}
		}
	}
	
	public static void pop() {
		answer++;
		for(int i = 0; i < popList.size(); i++) {
			int cr = popList.get(i)[0];
			int cc = popList.get(i)[1];
			board[cr][cc] = '.';
		}
		popList.removeAll(popList);
		
		// 맵내리기
		for(int i = N-1; i >= 0; i--) {
			for(int j = 0; j < M; j++) {
				boolean isColor = false;
				int row = 0;
				if(board[i][j] == '.') {
					for(int k = i; k >= 0; k--) {
						if(board[k][j] != '.') {
							isColor = true;
							row = k;
							break;
						}
					}
					
					if(isColor) {
						for(int k = 0; k < N && i-k >= 0 && row-k >= 0; k++) {
							board[i-k][j] = board[row-k][j];
							board[row-k][j] = '.';
						}
					}
				}
			}
		}
	}

}
