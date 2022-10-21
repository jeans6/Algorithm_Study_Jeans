import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

		int[] dp = new int[N];
		dp[0] = arr[0];
		int answer = dp[0];
		for(int i = 1; i < N; i++) {
			// (이전까지의합+현재합)과 현재 합 중 더 큰 값을 저장
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}

// https://steady-coding.tistory.com/180
