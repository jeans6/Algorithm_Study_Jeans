import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 남은날 내림차순
		PriorityQueue<int[]> pqByDate = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0]-o1[0];
			}
		});
		
		int endDate = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int date = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			pqByDate.offer(new int[] {date, score});
			endDate = Math.max(endDate, date);
		}
		
		int[] arr = new int[endDate+1];
		int cnt = endDate;
		while(cnt > 0) {
			// 점수 내림차순
			PriorityQueue<int[]> pqByScore = new PriorityQueue<int[]>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[1]-o1[1];
				}
			});
			
			// cnt날까지 할 수 있는 과제는 다 pqByScore에 넣음
			for(int i = 0; i < N; i++) {
				if(!pqByDate.isEmpty()) {
					int[] temp = pqByDate.peek();
					if(temp[0] >= cnt) {
						pqByScore.add(new int[] {temp[0], temp[1]});
						pqByDate.poll();
					} else break;
				}
			}
			
			// pqByScore의 첫번쨰 값이 젤 큰 점수
			if(pqByScore.size() > 0) {
				int[] temp = pqByScore.poll();
				arr[cnt] = temp[1];
			}
			// 사용안된거 다시 pqByDate에 넣어줌
			while(!pqByScore.isEmpty()) {
				pqByDate.offer(pqByScore.poll());
			}
			cnt--;
		}
		
		int sum = 0;
		for(int i = 0; i < endDate+1; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
