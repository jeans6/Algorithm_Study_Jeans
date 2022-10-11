import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][10];
		for(int i = 1; i < 10; i++) dp[0][i] = 1;
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) dp[i][j] = dp[i-1][j+1]; 
				else if(j == 9) dp[i][j] = dp[i-1][j-1];
				else dp[i][j] = dp[i-1][j-1]+dp[i-1][j+1];
                dp[i][j] %= 1000000000;
			}
		}
		
		int answer = 0;
		for(int i = 0; i < 10; i++) answer = (answer + dp[N-1][i])%1000000000;
		System.out.println(answer);
	}

}
// 참고 https://ssinee.tistory.com/37