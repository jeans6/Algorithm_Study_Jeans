import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] fee;
	static List<Integer>[] list;
	static boolean isPossible;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			isPossible = false;
			list = new ArrayList[N];
			fee = new int[N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String c = st.nextToken();
				int m = Integer.parseInt(st.nextToken());
				if(c.equals("T")) fee[i] = -m;
				else fee[i] = m;
				
				list[i] = new ArrayList<>();
				while(st.hasMoreTokens()) {
					int n = Integer.parseInt(st.nextToken());
					if(n == 0) break;
					list[i].add(n);
				}
			}
			
			if(fee[0] >= 0) {
				boolean[] visited = new boolean[N];
				visited[0] = true;
				dfs(0, 0, visited);
			}
			System.out.println(isPossible?"Yes":"No");
		}
	}
	
	static void dfs(int money, int cur, boolean[] visited) {
		if(cur >= N-1) {
			isPossible = true;
			return;
		}
		
		for(int i = 0; i < list[cur].size(); i++) {
			int next = list[cur].get(i)-1;
			// 방문체크
			if(visited[next]) continue;
			// 돈계산
			if(fee[next] >= 0 && fee[next] > money) money = fee[next];
			else if(fee[next] < 0 && money+fee[next] < 0) return;
			else money += fee[next];
			// 돈 모자라면 못 감
			visited[next] = true;
			dfs(money, next, visited);
		}
	}
}