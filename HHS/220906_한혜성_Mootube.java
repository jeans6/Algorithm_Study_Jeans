import java.io.*;
import java.util.*;

public class Main_BOJ_15591_MooTubeSilber{

	static int N, Q;
	static ArrayList<USADO>[] usado;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		Q = Integer.parseInt(str[1]);
		
		usado = new ArrayList[N+1];
		for(int i = 1; i < N+1; i++)
			usado[i] = new ArrayList<USADO>();
		
		for(int i = 0; i < N-1; i++) {
			str = br.readLine().split(" ");
			int p = Integer.parseInt(str[0]);
			int q = Integer.parseInt(str[1]);
			int r = Integer.parseInt(str[2]);
			usado[p].add(new USADO(q,r));
			usado[q].add(new USADO(p,r));
		}
		//질문 들어올때마다 v부터 쭉 훑으면서 
		for(int i = 0; i < Q; i++) {
			str = br.readLine().split(" ");
			int K = Integer.parseInt(str[0]);
			int start = Integer.parseInt(str[1]);
			int answer = 0;
			
			boolean [] visited = new boolean[N+1];
			visited[start] = true;
			
			Queue<Integer> que = new LinkedList<>();
			que.add(start);
			
			while(!que.isEmpty()) {
				int idx = que.poll();
				//idx에서 연결된 애들 보기
				//만약 연결된 애까지의 값이 k보다 작으면 큐에 넣지않아도 됨 어차피 작은값 선택해야하니까
				//K이상이면 방문처리하고 큐에 넣고 해당값과 작은값 비교해서 K이상이면 answer올리기 
				//이 과정 반복
				for(int s = 0; s < usado[idx].size(); s++) {
					int end = usado[idx].get(s).end;
					int num = usado[idx].get(s).num;
					
					if(end == start) continue;
					if(num >= K && !visited[end]) {
						answer++;
						que.add(end);
						visited[end] = true;
					}
				}
			}
			
			bw.write(String.valueOf(answer)+"\n");
		}
		bw.flush();
		bw.close();
	}

}
class USADO{
	int end;
	int num;
	public USADO(int end, int num) {
		super();
		this.end = end;
		this.num = num;
	}
}
