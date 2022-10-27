import java.io.*;
import java.util.*;

public class Main_BOJ_11724_연결요소의개수 {

	static int N, M;
	static int answer;
	static int [][] map;
	static boolean [] visited;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			map[i][i] = 1;
		}
		
		for(int m = 0; m < M; m++) {
			token = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			map[start][end] = 1;
			map[end][start] = 1;
		}
		
		answer = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j] == 1 && !visited[j]) {
					visited[j] = true;
					dfs(i,j,answer--);
				}
			}
		}
		bw.write(String.valueOf(answer*-1));
		bw.close();
	}

	private static void dfs(int start, int end, int cnt) {

		map[start][end] = cnt;

		for(int i = 1; i <= N; i++) {
			if(map[end][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(end, i, cnt);			
			}
		}
	}

}
