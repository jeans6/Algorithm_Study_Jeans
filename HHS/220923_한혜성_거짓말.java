import java.io.*;
import java.util.*;

public class Main_BOJ_1043_거짓말 {

	static int N, M;
	static int T;
	static int answer;
	static boolean [] truePeople;
	static HashSet<Integer>[] party;
	static int [] parents;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		truePeople = new boolean[N+1];
		parents = new int[N+1];
		party = new HashSet[M+1];
		for(int m = 1; m <= M; m++) {
			party[m] = new HashSet<>();
		}
		
		token = new StringTokenizer(br.readLine());
		T = Integer.parseInt(token.nextToken());

		for(int t = 0; t < T; t++) {//진실 아는애들 표시해주기
			truePeople[Integer.parseInt(token.nextToken())] = true;
		}
		
		make();//자기 자신을 부모로 만들기
		
		//파티 돌면서 부모 찾고 다르면 서로 이어주기
		for(int m = 1; m <= M; m++) {
			token = new StringTokenizer(br.readLine());
			int peopleCnt = Integer.parseInt(token.nextToken());
			int start = Integer.parseInt(token.nextToken());
			party[m].add(start);
			if(peopleCnt == 1) 
				continue; 
			for(int c = 0; c < peopleCnt-1; c++) {
				int now = Integer.parseInt(token.nextToken());
				if(find(start) != find(now)) 
					union(start, now);
				
				party[m].add(now);
				start = now;
			}
		}
		boolean [] visited = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			if(truePeople[i] && !visited[i]) {
				visited[i] = true;
				int p = find(i);
				for(int j = 1; j <= N; j++) {
					if(find(j) == p) {
						truePeople[j] = true;
						visited[j] = true;
					}
				}
			}
		}
		answer = M;
		for(int m = 1; m <= M; m++) {
			for(int num : party[m]) {
				if(truePeople[num]) {
					answer--;
					break;
				}
			}
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		
	}
	private static void union(int a, int b) {
		int p = find(b);
		parents[p] = a;
		
	}
	private static int find(int a) {
		if(parents[a] == a)
			return parents[a];
		
		parents[a] = find(parents[a]);
		return parents[a];
	}
	private static void make() {
		for(int i = 1; i <= N; i++) 
			parents[i] = i;
	}

}
