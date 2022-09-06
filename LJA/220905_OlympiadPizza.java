import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 큐에 (index, 조각수) 넣음
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < N; i++) queue.offer(new int[]{i, Integer.parseInt(st.nextToken())});
		
		// 조각이 1조각만 남았을 때 answer에 값 넣어줌
		// 2조각 이상이 남았을 땐 1조각 먹고 다시 queue에 줄 세움
		int[] answer = new int[N];
		int cnt = 1;
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			if(arr[1] == 1) answer[arr[0]] = cnt;
			else queue.offer(new int[]{arr[0], arr[1]-1});
			cnt++;
		}
		for(int i : answer) System.out.print(i+" ");
	}
}