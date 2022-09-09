import java.io.*;
import java.util.*;

public class Main_BOJ_1935_후위표기식2 {

	static int N;
	static String answer;
	static int alpha[];
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		alpha = new int[N];
		
		for(int i = 0; i < N; i++)
			alpha[i] = Integer.parseInt(br.readLine());
		
		Stack<Double> stack = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') 
				stack.push((double) alpha[str.charAt(i)-'A']);
			
			else if(str.charAt(i) == '+') {
				double b = stack.pop();
				double a = stack.pop();
				stack.push(Double.parseDouble(String.format("%.2f", a+b)));
			}else if(str.charAt(i) == '-') {
				double b = stack.pop();
				double a = stack.pop();
				stack.push(Double.parseDouble(String.format("%.2f", a-b)));
			}else if(str.charAt(i) == '/') {
				double b = stack.pop();
				double a = stack.pop();
				stack.push(Double.parseDouble(String.format("%.2f", a/b)));
			}else if(str.charAt(i) == '*') {
				double b = stack.pop();
				double a = stack.pop();
				stack.push(Double.parseDouble(String.format("%.2f", a*b)));
			}

		}
		answer = String.format("%.2f",stack.pop());
		
		bw.write(answer);
		bw.flush();
		bw.close();
	}

}
