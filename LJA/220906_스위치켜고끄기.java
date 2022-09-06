import java.util.Scanner;

public class Main {
	static int[] status;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		status = new int[N];
		for(int i = 0; i < N; i++) {
			status[i] = sc.nextInt();
		}
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			
			if(gender == 1) {
				for(int i = num-1; i < N; i+=num) {
					status[i] = (status[i]==0)? 1 : 0;
				}
			} else if(gender == 2) {
				status[num-1] = (status[num-1]==0)? 1 : 0;
				int left = num-2;
				int right = num;
				while(true) {
					if(left >= 0 && right < N) {
						if(status[left] == status[right]) {
							status[left] = (status[left]==0)? 1 : 0;
							status[right] = (status[right]==0)? 1 : 0;
							left--;
							right++;
						} else {
							left = -1;
							break;
						}
					} else {
						break;
					}
				}
			}
		}
		for(int i = 1; i <= status.length; i++) {
			System.out.print(status[i-1]+" ");
			if(i%20==0) System.out.println();
		}
	}
}