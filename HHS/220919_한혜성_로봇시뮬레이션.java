import java.io.*;
import java.util.*;

public class Main_BOJ_2174_로봇시뮬레이션 {

	static int A, B;
	static int N, M;
	static int [][] map; //위치에 따른 로봇 번호 넣을 예정
	static ArrayList<Robot> robot;
	static String answer = "OK";
	static String [] D = {"N", "W", "S", "E"}; //왼쪽으로 90도 순서
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(token.nextToken());
		B = Integer.parseInt(token.nextToken());
		
		map = new int[B][A];
		
		token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		robot = new ArrayList<>();
		
		for(int n = 1; n <= N; n++) {
			token = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());
			String d = token.nextToken();
			
			robot.add(new Robot(n, d, B-y, x-1));
			map[B-y][x-1] = n;
		}
		
		here : for(int m = 0; m < M; m++) {
			token = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(token.nextToken()); //로봇번호
			String dir = token.nextToken(); //명령어 L, R -> 방향 전환     F->이동
			int count = Integer.parseInt(token.nextToken()); //명령 실행 횟수  방향 전환 시 %4 번 실행
			
			Robot R = robot.get(num-1);
			int Didx = 0;
			for(int i = 0; i < 4; i++) {
				if(R.dir.equals(D[i])) Didx = i;
			}
			
			if(dir.equals("L"))	R.dir = D[(Didx+count)%4];		
			
			else if(dir.equals("R")) R.dir = D[(Didx+4-(count%4))%4];
			
			else {//방향 기준으로 앞으로 이동
				for(int cnt = 1; cnt <= count; cnt++) {
					
					int nr = R.r+(dr[Didx]*cnt);
					int nc = R.c+(dc[Didx]*cnt);
					if(!check(nr, nc)) {
						answer = "Robot "+R.number+" crashes into the wall";
						break here;
					}
					if(map[nr][nc] != 0) {
						answer = "Robot "+R.number+" crashes into robot "+map[nr][nc];
						break here;					
					}
				}
				map[R.r][R.c] = 0;
				map[R.r+(dr[Didx]*count)][R.c+(dc[Didx]*count)] = num;
				R.r += (dr[Didx]*count);
				R.c += (dc[Didx]*count);
			}
			
		}
		
		bw.write(answer);
		bw.flush();
		bw.close();
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < B && c < A;
	}

}
class Robot{
	int number;
	String dir;
	int r;
	int c;
	public Robot(int number, String dir, int r, int c) {
		super();
		this.number = number;
		this.dir = dir;
		this.r = r;
		this.c = c;
	}
}
