import java.io.*;
import java.util.*;

public class Main_BOJ_13904_과제 {

	static int N;
	static int answer;
	static ArrayList<Work> work;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = null;
		
		N = Integer.parseInt(br.readLine());
		int Max = 0;
		work = new ArrayList<>();
		
		for(int n = 0; n < N; n++) {
			token = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(token.nextToken());
			int w = Integer.parseInt(token.nextToken());
			work.add(new Work(d, w));
			Max = Math.max(Max, d);
		}
		Collections.sort(work, new Comparator<Work>() {
			@Override
			public int compare(Work o1, Work o2) {
				int comp = o1.d- o2.d;
				if(comp == 0)
					return o2.w - o1.w;
				else return comp;
			}
		});

		int cnt = Max;
		while(cnt > 0) {
			PriorityQueue<int []> que = new PriorityQueue<>(new Comparator<int []>() {
				@Override
				public int compare(int [] o1, int [] o2) {
					return o2[2] - o1[2];
				}
			});

			for(int i = 0; i < work.size(); i++) {
				if(work.get(i).d >= cnt)
					que.offer(new int [] {i, work.get(i).d, work.get(i).w});
			}
			if(!que.isEmpty()) {
				int [] w = que.poll();
				answer += w[2];
				work.remove(w[0]);
			}
			cnt--;
		}
		
		bw.write(String.valueOf(answer));
		bw.close();
		
	}

}
class Work{
	int d;
	int w;
	public Work(int d, int w) {
		super();
		this.d = d;
		this.w = w;
	}
}
