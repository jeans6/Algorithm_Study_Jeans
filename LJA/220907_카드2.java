import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) queue.offer(i);
		
		boolean toggle = true;
		while(queue.size() > 1) {
			if(toggle) queue.poll();
			else queue.offer(queue.poll());
			toggle = !toggle;
		}
		System.out.println(queue.poll());
	}

}