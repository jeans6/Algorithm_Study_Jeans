import java.io.*;
import java.util.*;

public class Main_BOJ_1802_종이접기 {

	static int T;
	static String answer;
	static String str;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			answer = "YES";
			str = br.readLine();
			dc(str.length()/2, str.length()/2);
			
			bw.write(answer+"\n");
		}
		bw.close();
		
	}

	private static void dc(int size, int m) {

		if(size == 0) return;
		
		int len = 1;
		boolean check = false;
		while(len <= size) {
			if(str.charAt(m - len) == str.charAt(m + len)) {
				check = true;
				break;
			}
			len++;
		}
		if(check) {
			answer = "NO";
			return;
		}
		else if(!check && answer.equals("YES")){
			dc(size/2, m-1-size/2);
			dc(size/2, m+1+size/2);
		}
	}

}
