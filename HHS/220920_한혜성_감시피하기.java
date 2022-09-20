import java.io.*;
import java.util.*;

public class Main_BOJ_18428_감시피하기 {

	static int N;
	static int [][] map; // 선생님 = 1, 학생 = 2, 장애물 = 3
	static String answer = "NO";
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,1,0,-1};
	static ArrayList<Integer> obstacle;
	static ArrayList<Integer> teacher;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		teacher = new ArrayList<>();
		obstacle = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < str.length; j++) {
				if(str[j].equals("T")) {
					map[i][j] = 1;
					teacher.add(i*N + j);
				}
				else if(str[j].equals("S"))
					map[i][j] = 2;
				else
					obstacle.add(i*N + j);
			}
		}
		
		Comb(0,0,new int[3]);
		
		bw.write(answer);
		bw.flush();
		bw.close();
	}

	private static void Comb(int start, int cnt, int[] nums) {
		if(answer.equals("YES")) return;
		if(cnt == 3) {
			for(int i = 0; i < 3; i++) {
				int idx = obstacle.get(nums[i]);
				map[idx/N][idx%N] = 3;
			}
			find();
			for(int i = 0; i < 3; i++) {
				int idx = obstacle.get(nums[i]);
				map[idx/N][idx%N] = 0;
			}
			
			return;
		}
		
		for(int i = start; i < obstacle.size(); i++) {
			nums[cnt] = i;
			Comb(i+1, cnt+1, nums);
		}
		
	}

	private static void find() {
		// 선생들의 위치를 기준으로 4방탐색 각각해서
		// 3이거나 벽만 보이면 통과
		// 2를 마주치게 되면 그냥 나가기
		Queue<Teacher> que = new LinkedList<>();
		for(int i = 0; i < teacher.size(); i++) {
			//방향값과 인덱스값 넣어주기
			que.add(new Teacher(teacher.get(i), 0));
			que.add(new Teacher(teacher.get(i), 1));
			que.add(new Teacher(teacher.get(i), 2));
			que.add(new Teacher(teacher.get(i), 3));
		}
		boolean findStudent = false;
		while(!que.isEmpty()) {
			Teacher t = que.poll();
			int nr = t.idx / N + dr[t.d];
			int nc = t.idx % N + dc[t.d];
			
			if(!check(nr, nc)) continue;
			if(map[nr][nc] == 2) {
				findStudent = true;
				break;
			}
			else if(map[nr][nc] == 0) 
				que.add(new Teacher(nr*N + nc, t.d));
			
		}
		if(!findStudent)
			answer = "YES";
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
class Teacher{
	int idx;
	int d;
	public Teacher(int idx, int d) {
		super();
		this.idx = idx;
		this.d = d;
	}
}
