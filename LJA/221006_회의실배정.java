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
		List<Meeting> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Meeting(start, end));
		}
		
		Collections.sort(list);
		int cnt = 1;
		int s = list.get(0).end;
		for(int i = 1; i < list.size(); i++) {
			if(s <= list.get(i).start) {
				cnt++;
				s = list.get(i).end;
			}
		}
		System.out.println(cnt);
	}
	
	public static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		
		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			int t = this.end-o.end;
			if(t==0) return this.start-o.start;
			return t;
		}
	}
	
}