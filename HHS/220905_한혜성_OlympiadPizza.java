import java.io.*;
import java.util.*;

public class Main_BOJ_15235_OlympiadPizza {

	static int N;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int [] answer = new int[N];
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		Queue<Pizza> que = new LinkedList<>();
		for(int i = 0; i < N; i++)
			que.add(new Pizza(i, Integer.parseInt(token.nextToken())));
				
		int cnt = 1;
		while(!que.isEmpty()) {
			Pizza p = que.poll();
			if(p.count == 1) {
				answer[p.idx] = cnt;				
			}else {
				que.add(new Pizza(p.idx, p.count-1));
			}
			cnt++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++)
			sb.append(answer[i]).append(" ");
		
		System.out.println(sb.toString());
	}

}
class Pizza{
	int idx;
	int count;
	
	public Pizza(int idx, int count){
		super();
		this.idx = idx;
		this.count = count;
	}
}
