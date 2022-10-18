import java.io.*;
import java.util.*;

public class Main_BOJ_1912_연속합 {

	static int N;
	static int[] dp;
	static int[] input;
	static int Max;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		String [] str = br.readLine().split(" ");
		dp = new int[N];
		input = new int[N];

		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(str[i]);
		}
		
		Max = input[0];
		dp[0] = input[0];
		for(int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i-1]+ input[i], input[i]);
			Max = Math.max(dp[i], Max);
		}
		
		bw.write(String.valueOf(Max));
		bw.close();
		
	}

	

}
