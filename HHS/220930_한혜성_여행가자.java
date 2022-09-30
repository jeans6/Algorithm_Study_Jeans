import java.io.*;

public class Main_BOJ_1976_여행가자 {

	static int N; //총도시
	static int M; //가려는 도시
	static String answer;
	static int [] goal;
	static int [] parents;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parents = new int[N+1];
		make();
		
		for(int i = 1; i <= N; i++) {
			String [] str = br.readLine().split(" ");
			for(int j = 1; j <= N; j++) {
				if(Integer.parseInt(str[j-1]) == 1 ) {
					union(i,j);
				}
			}
		}
		
		goal = new int[M];
		String [] str = br.readLine().split(" ");
		for(int i = 0; i < M; i++)
			goal[i] = Integer.parseInt(str[i]);
		
		answer = "YES";
		for(int i = 1; i < M; i++) {
			if(find(goal[0]) != find(goal[i])) {
				answer = "NO";
				break;
			}
		}
		
		bw.write(answer);
		bw.flush();
		bw.close();
		
	}

	private static void make() {
		for(int i = 1; i <= N; i++)
			parents[i] = i;
	}
	
	private static int find(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
	
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) {
			if(a < b)
				parents[pb] = pa;
			else 
				parents[pa] = pb;
		}
	}

}
