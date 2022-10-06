import java.io.*;
import java.util.*;

public class Main_BOJ_18427_함께블록쌓기 {

	static int N, M, H;
	static int [][] dp;
	static ArrayList<Integer>[] block;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = null; 
		token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		H = Integer.parseInt(token.nextToken());
		
		block = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			block[i] = new ArrayList<Integer>();
			String [] str = br.readLine().split(" ");
			for(int j = 0; j < str.length; j++)
				block[i].add(Integer.parseInt(str[j]));
		}
		
		dp = new int[N+1][H+1];
		
		for(int i = 1; i <= N; i++)
			dp[i][0] = 1;
		for(int j = 0; j < block[1].size(); j++) {
			dp[1][block[1].get(j)] = 1; 
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j <= H; j++) {
				dp[i][j] = dp[i-1][j];
				for(int a = 0; a < block[i].size(); a++) {
					if(block[i].get(a) > j) continue;
					int h = j - block[i].get(a);
					if(dp[i-1][h] > 0)
						dp[i][j] += dp[i-1][h];
				}
				dp[i][j] %= 10007;
			}
		}

		bw.write(String.valueOf(dp[N][H]));
		bw.flush();
		bw.close();
	}

}
