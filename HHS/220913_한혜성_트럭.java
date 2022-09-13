import java.io.*;
import java.util.*;

public class Main_BOJ_13335_트럭 {

	static int N, W, L;
	static int [] bus;
	static int time;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());
		W = Integer.parseInt(token.nextToken());
		L = Integer.parseInt(token.nextToken());
		
		bus = new int[N];
		token = new StringTokenizer(br.readLine());

		Queue<Integer> que = new LinkedList<>();//무게 넣기 넣을 수 없으면 그냥 0 넣기
		
		for(int i = 0; i < N; i++)
			bus[i] = Integer.parseInt(token.nextToken());
		
		int sum = 0;
		int now = 0;

		while(now < N) {
			if(que.isEmpty()) {
				sum = bus[now];
				que.offer(bus[now++]);
				time++;
			}else if(que.size() == W) {
				sum -= que.poll();
			}else if(sum + bus[now] > L) {
				que.offer(0);
				time++;
			}else {
				sum += bus[now];
				que.offer(bus[now++]);
				time++;
			}
			
			
		}
		time += W;
		bw.write(String.valueOf(time));
		bw.flush();
		bw.close();
		
	}

}
