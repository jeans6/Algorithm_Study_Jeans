import java.io.*;
import java.util.*;

public class Main_BOJ_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = new StringTokenizer(br.readLine(), "-+", true); //구분자 포함해서 자르기
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		while(token.hasMoreTokens()) {
			String str = token.nextToken();
			if(str.equals("+")) {
				int num1 = deque.pollLast();
				int num = Integer.parseInt(token.nextToken());
				deque.offerLast(num+num1);
			}else if(str.equals("-")){
				int num = Integer.parseInt(token.nextToken());
				deque.offerLast(num);
			}else {
				deque.offer(Integer.parseInt(str));				
			}			
			
		}
		
		int num = deque.pollFirst();
		while(!deque.isEmpty()) {
			num -= deque.pollFirst();
		}
		bw.write(String.valueOf(num));
		bw.close();
	}

}
