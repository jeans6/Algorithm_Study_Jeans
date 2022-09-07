import java.io.*;
import java.util.*;

public class Main_BOJ_2164_카드2 {

	static int N;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Queue<Integer> que = new LinkedList<>();
		int answer = 0;
		boolean check = true; // 버릴 차례이면 true
		for(int i = 1; i <= N; i++)
			que.offer(i);
		
		while(!que.isEmpty()) {
			if(que.size() == 1) {
				answer = que.poll();
				break;
			}
			if(check) {
				que.poll();
				check = false;
			}else {
				que.offer(que.poll());
				check = true;
			}
				
		}
		
		System.out.println(answer);
	}

}
