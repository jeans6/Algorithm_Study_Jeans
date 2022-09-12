import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int time = 0;
		int weight = 0;
		Queue<Integer> bridge = new LinkedList<>();
		st = new StringTokenizer(sc.nextLine());
		while(st.hasMoreTokens()) {
			int n = Integer.parseInt(st.nextToken());
			while(true) {
				if(bridge.size()+1 > W) { // 트럭 개수 초과
					weight -= bridge.poll();
				} else if(weight+n > L) { // 하중 초과
					bridge.offer(0);
					time++;
				} else { // 올라가기 가능
					bridge.add(n);
					weight += n;
					time++;
					break;
				}
			}
		}
		System.out.println(time+W);
	}
}