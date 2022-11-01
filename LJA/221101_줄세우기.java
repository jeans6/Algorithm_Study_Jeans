import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N];
		dp[0] = 1;
		int cnt = 0;
		for(int i = 1; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
			cnt = Math.max(cnt, dp[i]);
		}
		System.out.println(N-cnt);
	}

}
