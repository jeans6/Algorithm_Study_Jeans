import java.io.*;

public class Main_BOJ_10844 {

	static int N;
	static long answer;
	static int INF = 1000000000;
	static long [][] dp;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new long[10][2];

		for(int i = 0; i <= 9; i++)
			dp[i][0] = 1;
		
		for(int n = 2; n <= N; n++) {
			for(int i = 0; i <= 9; i++) {
				if(i == 0) 
					dp[i][(n+1)%2] = dp[1][n%2];
				else if(i == 9)
					dp[i][(n+1)%2] = dp[8][n%2];
				else
					dp[i][(n+1)%2] = dp[i-1][n%2] + dp[i+1][n%2];
				dp[i][(n+1)%2] %= INF;
			}
		}
		
		
		for(int i = 1; i <= 9; i++) {
			answer += dp[i][(N+1)%2];
		}
		bw.write(String.valueOf(answer%INF));
		bw.close();
	}

}
