import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[i][0] = start;
			arr[i][1] = end;
		}
		
		Arrays.sort(arr, (o1, o2)->{
			int t = o1[1]-o2[1];
			if(t==0) return o1[0]-o2[0];
			return t;
		});
		int cnt = 1;
		int s = arr[0][1];
		for(int i = 1; i < N; i++) {
			if(s <= arr[i][0]) {
				cnt++;
				s = arr[i][1];
			}
		}
		System.out.println(cnt);
	}
	
}
