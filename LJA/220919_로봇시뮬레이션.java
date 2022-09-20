import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int row, col, R, C;
	static int[][] map;
	// N,E,S,W 순
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Robot[] robots;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		robots = new Robot[R];
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			robots[r] = new Robot(r, row-y, x-1, directionToInteger(st.nextToken()));
			map[robots[r].y][robots[r].x] = robots[r].n;
		}
		
		for(int c = 0; c < C; c++) {
			st = new StringTokenizer(br.readLine());
			int robotNum = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			int repeat = Integer.parseInt(st.nextToken());
			String result = "";
			Robot temp = robots[robotNum-1];
			
			// 방향전환
			if(d == 'R') temp.d = (temp.d+repeat)%4;
			else if(d == 'L') temp.d = (temp.d+4-(repeat%4))%4;
			else {
				// 이동
				for(int i = 0; i < repeat; i++) {
					map[temp.y][temp.x] = 0;
					temp.y = temp.y+dr[temp.d];
					temp.x = temp.x+dc[temp.d];
					result = checkMap(temp.n, temp.y, temp.x);
					if(!result.equals("")) {
						System.out.println(result);
						return;
					}
					map[temp.y][temp.x] = temp.n; 
				}
			}
			robots[robotNum-1] = temp;
		}
		System.out.println("OK");
	}
	
	public static class Robot {
		int n;
		int y;
		int x;
		int d;
		
		Robot(int n, int y, int x, int d) {
			this.n = n+1;
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
	
	public static String checkMap(int n, int y, int x) {
		if(x<0 || y<0 || x>=col || y>=row) return "Robot "+n+" crashes into the wall";
		if(map[y][x] != 0) return "Robot "+n+" crashes into robot "+map[y][x];
		return "";
	}
	
	public static int directionToInteger(String s) {
		if(s.equals("N")) return 0;
		else if(s.equals("E")) return 1;
		else if(s.equals("S")) return 2;
		else if(s.equals("W")) return 3;
		return 0;
	}
}
