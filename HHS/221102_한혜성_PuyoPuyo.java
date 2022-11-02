import java.io.*;
import java.util.*;
 
public class Main_BOJ_11559_PuyoPuyo {

	static char [][] map;
	static int answer;
	static int []dr = {-1,0,1,0};
	static int []dc = {0,1,0,-1};
	static boolean flag;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		map = new char[12][6];
		
		for(int i = 0; i < 12; i++) {
			String str = br.readLine();
			for(int j = 0; j < 6; j++)
				map[i][j] = str.charAt(j);
		}
		
		//밑에서부터 보면서 4방탐색 후 터지는 애들 . 으로 표시한 후 더이상 터질 애들 없으면 answer++;
		//.이고 윗칸에 올라가면 알파벳 있을 경우 해당 칸 수 만큼 내려주기
		while(true) {
			flag = false;
			for(int i = 0; i < 12; i++) {
				for(int j = 0; j < 6; j++) {
					if(map[i][j] != '.') {
						find(i, j);
					}
				}
			}
			if(!flag) break;
			else {
				answer++;
				//없앨 애들이 있는 것임
				//.으로 터진애들 처리한 것을 토대로 위에 있는 애들 내려주기
				for(int i = 0; i < 6; i++) {
					int alphaCnt = 0;
					boolean down = false;
					for(int j = 11; j >= 0; j--) {
						if(map[j][i] == '.') down = true;
						else {
							if(down) {
								map[11-alphaCnt][i] = map[j][i];
								map[j][i] = '.';
							}
							alphaCnt++;
						}
					}
				}

			}
		}
		bw.write(String.valueOf(answer));
		bw.close();
	}

	private static void find(int r, int c) {

		int cnt = 0;
		Queue<int [] > que = new LinkedList<>();
		que.offer(new int[] {r,c});
		
		boolean [][] visited = new boolean[12][6];
		visited[r][c] = true;
		
		while(!que.isEmpty()) {
			int [] q = que.poll();
			cnt++;
			for(int d = 0; d < 4; d++) {
				int nr = q[0]+dr[d];
				int nc = q[1]+dc[d];
				
				if(!check(nr, nc)) continue;
				if(visited[nr][nc]) continue;
				if(map[r][c] != map[nr][nc]) continue;
				
				visited[nr][nc] = true;
				que.offer(new int[] {nr, nc});
			}
			
		}
		
		if(cnt < 4) return;
		flag = true;
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 6; j++) {
				if(visited[i][j])
					map[i][j] = '.';
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < 12 && c >= 0 && c < 6;
	}

}
