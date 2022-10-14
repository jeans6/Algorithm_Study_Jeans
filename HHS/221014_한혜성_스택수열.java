import java.io.*;
import java.util.*;

public class Main_BOJ_1876_스택수열 {

	static String answer;
	static int N;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		int num = 1;
		answer = "";
		Stack<Integer> stack = new Stack<>();
		int cnt = 1;
		while(cnt <= N) {
			int cur = Integer.parseInt(br.readLine());

			while(num <= cur) {
				stack.push(num);
				sb.append("+\n");
				num++;
			}
			
			if(!stack.isEmpty() && stack.peek() > cur) {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
			
			if(!stack.isEmpty() && stack.peek().equals(cur)) {
				stack.pop();
				sb.append("-\n");
			}
			cnt++;
		}
		
		bw.write(sb.toString());
		bw.close();
	}

}
