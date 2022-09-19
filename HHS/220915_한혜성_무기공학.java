import java.io.*;
import java.util.*;

public class Main_BOJ_18430_무기공학 {

	static int N, M;
	static int [][] map;
	static int answer;
	static boolean [][] visited;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = null; 
		token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(token.nextToken());
		}
		
		if(N < 2 || M < 2)
			answer = 0;
		
		else 
			dfs(0, 0, 0);
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		
	}

	private static void dfs(int r, int c, int sum) {
		if(r >= N) {
			answer = Math.max(answer, sum);
			return;
		}
		
		if(!visited[r][c]) {
			if(check(r+1, c) && check(r, c+1) && !visited[r+1][c] && !visited[r][c+1]) { //r
				visited[r+1][c] = true;
				visited[r][c] = true;
				visited[r][c+1] = true;
				
				if(check(r, c+1)) 
					dfs(r, c+1, sum+cal(r, c, r+1, c, r, c+1));
				else 
					dfs(r+1, 0, sum+cal(r, c, r+1, c, r, c+1));
				
				visited[r+1][c] = false;
				visited[r][c] = false;
				visited[r][c+1] = false;
			}
			if(check(r+1, c) && check(r, c-1) && !visited[r+1][c] && !visited[r][c-1]) { //ㄱ
				visited[r+1][c] = true;
				visited[r][c] = true;
				visited[r][c-1] = true;
				
				if(check(r, c+1)) 
					dfs(r, c+1, sum+cal(r, c, r+1, c, r, c-1));
				else 
					dfs(r+1, 0, sum+cal(r, c, r+1, c, r, c-1));
				
				visited[r+1][c] = false;
				visited[r][c] = false;
				visited[r][c-1] = false;
			}
			if(check(r-1, c) && check(r, c+1) && !visited[r-1][c] && !visited[r][c+1]) { //ㄴ
				visited[r-1][c] = true;
				visited[r][c] = true;
				visited[r][c+1] = true;
				
				if(check(r, c+1)) 
					dfs(r, c+1, sum+cal(r, c, r-1, c, r, c+1));
				else 
					dfs(r+1, 0, sum+cal(r, c, r-1, c, r, c+1));
				
				visited[r-1][c] = false;
				visited[r][c] = false;
				visited[r][c+1] = false;
			}
			if(check(r-1, c) && check(r, c-1) && !visited[r-1][c] && !visited[r][c-1]) { //ㅢ
				visited[r-1][c] = true;
				visited[r][c] = true;
				visited[r][c-1] = true;
				
				if(check(r, c+1)) 
					dfs(r, c+1, sum+cal(r, c, r-1, c, r, c-1));
				else 
					dfs(r+1, 0, sum+cal(r, c, r-1, c, r, c-1));
				
				visited[r-1][c] = false;
				visited[r][c] = false;
				visited[r][c-1] = false;
			}
			
		}
		
		if(check(r, c+1)) dfs(r, c+1, sum);
		else dfs(r+1, 0, sum);
		
		
		
		
	}

	private static int cal(int r1, int c1, int r2, int c2, int r3, int c3) {
		return (map[r1][c1]*2) + map[r2][c2] + map[r3][c3];
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
