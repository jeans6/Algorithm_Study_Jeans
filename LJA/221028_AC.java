import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			char[] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> dq = new ArrayDeque<>();
			
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str.substring(1, str.length()-1), ",");
			for(int i = 0; i < n; i++) dq.addLast(Integer.parseInt(st.nextToken()));

			boolean seq = true;
			boolean isError = false;
			for(int i = 0; i < p.length; i++) {
				if(p[i] == 'R') {
					seq = !seq;
				} else if(p[i] == 'D') {
					if(dq.size() == 0) {
						isError = true;
						break;
					}
					if(seq && dq.size() > 0) dq.pollFirst();
					else if(!seq && dq.size() > 0) dq.pollLast();
				}
				if(isError) break;
			}
			
			if(isError) System.out.println("error");
			else {
				if(!seq) {
					Deque<Integer> temp = new ArrayDeque<>();
					while(!dq.isEmpty()) {
						temp.addLast(dq.pollLast());
					}
					System.out.println(temp.toString().replace(" ", ""));
				} else {
					System.out.println(dq.toString().replace(" ", ""));
				}
			}
		}
	}
	
}
