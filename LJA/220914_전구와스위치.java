import java.util.Scanner;

public class Main {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		char[] before1 = sc.nextLine().toCharArray();
		char[] before2 = before1.clone();
		char[] after = sc.nextLine().toCharArray();
		
		// 1전구를 기준으로 나누는 이유는 첫번째 전구의 상태는 1,2 전구만 바꿀 수 있기 때문이라고 한다~
		// before와 after의 i-1상태를 비교하면서 바꾸는거~
		int cnt1 = 1;
		int cnt2 = 0;
		turn(before1, 0);
		for(int i = 1; i < N; i++) {
			if(before1[i-1] != after[i-1]) {
				turn(before1, i);
				cnt1++;
			}
			if(before2[i-1] != after[i-1]) {
				turn(before2, i);
				cnt2++;
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(before1[i] != after[i]) cnt1 = Integer.MAX_VALUE;
			if(before2[i] != after[i]) cnt2 = Integer.MAX_VALUE;
		}
		int answer = Math.min(cnt1, cnt2);
		System.out.println(answer!=Integer.MAX_VALUE?answer:-1);
	}
	
	static void turn(char[] arr, int idx) {
		for(int i = idx-1; i < idx+2; i++) {
			if(i >= 0 && i < N) arr[i] = arr[i]=='1'?'0':'1';
		}
	}
}