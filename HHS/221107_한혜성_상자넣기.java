import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int answer;
	static int [] dp;
	static int [] nums;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		nums = new int[N];
		dp = new int[N];
		
		for(int i = 0; i < N; i++) 
			nums[i] = Integer.parseInt(token.nextToken());
		
		for(int i = 0; i < N; i++)
			dp[i] = 1;
		int Max = 0;
		for(int i = 1; i < N; i++) {
			for(int j = i-1; j >= 0; j--) {
				if(nums[i] > nums[j])
					dp[i] = Math.max(dp[j]+1, dp[i]);
			}
			Max = Math.max(Max, dp[i]);
		}
		
		
		bw.write(String.valueOf(Max));
		bw.close();
		
	}

}