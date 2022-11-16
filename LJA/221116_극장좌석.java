import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		// 피보나치 수열 만들기
		int[] dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i < dp.length; i++) dp[i] = dp[i-1]+dp[i-2];
		// 빈좌석 수에 해당하는 경우의 수들 곱
		long answer = 1;
		int start = 1;
		int end = 0;
		for(int i = 0; i < M; i++) {
			end = Integer.parseInt(br.readLine());
			answer *= dp[end-start];
			start = end+1;
		}
		answer *= dp[N-end];
		System.out.println(answer);
	}
}
