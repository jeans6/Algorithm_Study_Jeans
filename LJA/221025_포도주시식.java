import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N];
		dp[0] = arr[0];
		if(N > 1) dp[1] = arr[0]+arr[1];
		// 와인이 3잔일 경우 : dp[1](2번쨰 와인까지 마셨을때 최대값)과 3번째 와인과 dp[0]을 마신거
		// 혹은 3번째와 2번쨰를 마신것 중에 큰 값으로 업데이트
		if(N > 2) dp[2] = Math.max(dp[1], arr[2] + Math.max(dp[0], arr[1]));
		
		for(int i = 3; i < N; i++) {
			// 전와인까지의 최대양, 전전와인과 현재 와인을 마실 때 혹은 전전전와인과 현재 와인을 마실때 더 큰 값으로 업데이트
			dp[i] = Math.max(dp[i-1], arr[i] + Math.max(dp[i-2], dp[i-3]+arr[i-1]));
		}
		
		System.out.println(dp[N-1]);
	}
}

// https://minhamina.tistory.com/155
