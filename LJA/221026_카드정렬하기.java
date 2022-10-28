import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		long answer = 0;
		while(pq.size()>1) {
			int a = pq.poll();
			int b = pq.poll();
			if(!pq.isEmpty()) pq.add(a+b);
			answer += a+b;
		}
		System.out.println(answer);
	}
	
}
