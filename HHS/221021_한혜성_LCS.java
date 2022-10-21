import java.io.*;
import java.util.*;

public class Main_BOJ_9251_LCS {

	static String A;
	static String B;
	static int [][] dp;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		A = br.readLine();
		B = br.readLine();
		dp = new int[A.length()][B.length()];
		
		boolean check = false;
		for(int i = 0; i < A.length(); i++) {
			if(check) {
				dp[i][0] = 1;
				continue;
			}
			if(A.charAt(i) == B.charAt(0)) {
				dp[i][0] = 1;
				check = true;
			}
		}
		check = false;
		for(int i = 1; i < B.length(); i++) {
			if(check) {
				dp[0][i] = 1;
				continue;
			}
			if(A.charAt(0) == B.charAt(i)) {
				dp[0][i] = 1;
				check = true;
			}
		}
		
		for(int i = 1; i < A.length(); i++) {
			for(int j = 1; j < B.length(); j++) {
				if(A.charAt(i) == B.charAt(j)) 
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		bw.write(String.valueOf(dp[A.length()-1][B.length()-1]));
		bw.close();
	}

}
