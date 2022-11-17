package study_jeans;

import java.io.*;

public class Main_BOJ_2302_극장좌석 {

	static int N;
	static int T;
	static int [] dp;
	static int answer = 1;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		T = Integer.parseInt(br.readLine());

		dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= 40; i++)
			dp[i] = dp[i-1]+dp[i-2];
		
		int pre = 0;
		for(int t = 1; t <= T; t++) {
			int now = Integer.parseInt(br.readLine());
			answer *= dp[now-pre-1];
			pre = now;
		}
		
		if(pre != N) answer *= dp[N-pre];
		
		bw.write(String.valueOf(answer));
		bw.close();
	}

}
