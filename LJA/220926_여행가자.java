import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i==j) map[i][j] = 1;
			}
		}
		
		boolean isPossible = true;
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][k] == 1 && map[k][j] == 1) map[i][j] = 1;
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken())-1;
		while(st.hasMoreTokens()) {
			int m = Integer.parseInt(st.nextToken())-1;
			if(map[k][m] == 0) {
				isPossible = false;
				break;
			}
			k = m;
		}
		System.out.println(isPossible?"YES":"NO");
	}
}