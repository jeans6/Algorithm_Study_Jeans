import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		for(int i = 0; i < N-1; i++) answer += distance(arr, i, i+1);
		int max = -1;
		for(int i = 0; i < N-2; i++) {
			int skip = distance(arr, i, i+2);
			int original = distance(arr, i, i+1)+distance(arr, i+1, i+2);
			// i -> i+2로 가는 길과 i->i+1->i+2로 가는 길의 차가 큰 값을 저장
			max = Math.max(max, original-skip);
		}
		System.out.println(answer-max);
	}

	public static int distance(int[][] arr, int from, int to) {
		return Math.abs(arr[from][0]-arr[to][0])+Math.abs(arr[from][1]-arr[to][1]);
	}
}