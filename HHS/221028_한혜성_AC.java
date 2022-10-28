import java.io.*;
import java.util.*;

public class Main_BOJ_5430_AC {

	static int T;
	static String answer = "error";
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String str = br.readLine();
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer token = new StringTokenizer(br.readLine(), "[],");
			Deque<Integer> dq = new ArrayDeque<>();
			for(int i = 0; i < N; i++)
				dq.offer(Integer.parseInt(token.nextToken()));
			
			boolean left = true;
			boolean err = false;
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == 'D') {
					if(dq.size() > 0) {
						if(left) dq.pollFirst();
						else dq.pollLast();								
					}else {
						bw.write(answer+"\n");
						err = true;
						break;
					}
				
				}else left = !left;
				
			}
			
			if(!err) {
				bw.write("[");
				int s = dq.size();
				for(int i = 0; i < s; i++) {
					if(left) {
						if(i != s-1) bw.write(String.valueOf(dq.pollFirst()+","));
						else bw.write(String.valueOf(dq.pollFirst()));
					}
					else {
						if(i != s-1) bw.write(String.valueOf(dq.pollLast()+","));
						else bw.write(String.valueOf(dq.pollLast()));
					}
				}
				bw.write("]\n");
			}
			
		}
		bw.close();
		
	}

}
