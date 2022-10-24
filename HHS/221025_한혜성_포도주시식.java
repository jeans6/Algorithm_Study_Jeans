import java.io.*;
import java.util.*;

public class Main_BOJ_2156_포도주시식 {

	static int N;
	static int [] wine;
	static int [] dp;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		N = Integer.parseInt(br.readLine());
		
		wine = new int[N+1];
		dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		wine[0] = 0;
		dp[1] = wine[1];
		
		if(N > 1) {
			dp[2] = dp[1] + wine[2];
		}
		int max = 0;
		for (int i = 3; i <= N; i++) {
			
			max = Math.max(dp[i-2], dp[i-3]+wine[i-1]);
			dp[i] = Math.max(max, dp[i-3]) + wine[i];
			
			dp[i] = Math.max(dp[i], dp[i-1]);
		}
		
        bw.write(String.valueOf(dp[N]));
        bw.close();
		
	}

}
