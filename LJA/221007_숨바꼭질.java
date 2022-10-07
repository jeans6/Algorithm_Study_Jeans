import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, K, min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		min = Integer.MAX_VALUE;
		System.out.println(bfs(new HashSet<Integer>()));
	}
	
	public static int bfs(HashSet<Integer> visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {N, 0});
		visited.add(N);
		while(!queue.isEmpty()) {
			int[] n = queue.poll();
			if(n[0]==K) return n[1];
			
			if(n[0]-1 >= 0 && !visited.contains(n[0]-1)) {
				queue.offer(new int[] {n[0]-1, n[1]+1});
				visited.add(n[0]);
			}
			if(n[0]+1 <= 100000 && !visited.contains(n[0]+1)) {
				queue.offer(new int[] {n[0]+1, n[1]+1});
				visited.add(n[0]+1);
			}
			if(2*n[0] <= 100000 && !visited.contains(2*n[0])) {
				queue.offer(new int[] {n[0]*2, n[1]+1});
				visited.add(n[0]*2);
			}
			
		}
		return 0;
	}
}
