import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] dist = new int[N];
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		while(!isfull(arr)) {
			for(int i = N-1; i >= 0; i--) {
				int prev = i;
				if(arr[i] == 0) {
					int d = 0;
					dist[i] = 0;
					while(arr[(prev--+N)%N] < 1) dist[i]++;
					if(dist[i] > 0) {
						prev = (i-dist[i]+N)%N;
						arr[i]++;
						arr[prev]--;
					}
					dist[i] += dist[prev];
				}
			}
		}
		int energy = 0;
		for(int i : dist) energy += i*i;
		System.out.println(energy);
	}
	
	public static boolean isfull(int[] arr) {
		for(int i = 0; i < arr.length; i++) if(arr[i] != 1) return false;
		return true;
	}
	
}