import java.io.*;
import java.util.*;

public class Main_BOJ_16918_봄버맨 {

	static int R,C,T;
	static int [][] map;
	static char [][] bomb;
	static int [] dr = {-1,0,1,0,0};
	static int [] dc = {0,1,0,-1,0};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		T = Integer.parseInt(token.nextToken());
		
		map = new int[R][C];
		bomb = new char[R][C];
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				bomb[i][j] = str.charAt(j);
				if(bomb[i][j] == 'O')
					map[i][j] = 0;
				else 
					map[i][j] = 2;
			}
		}
		StringBuilder sb = new StringBuilder();
		if(T == 1) {
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					sb.append(bomb[i][j]);
				}sb.append("\n");
			}
			System.out.print(sb.toString());

		}else if(T == 2){
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					sb.append('O');
				}sb.append("\n");
			}
			System.out.print(sb.toString());	

		}else {

            int time = 3;
			while(time <= T) {
				Queue<Bomb> que = new LinkedList<>();
				for(int i = 0; i < R; i++) {
					for(int j = 0; j < C; j++) {
						if(time - map[i][j] == 3)
							que.add(new Bomb(i, j));
						else if(map[i][j] == -1)
							map[i][j] = time;
					}
				}
				
				fire(que);
				time++;
			}
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(map[i][j] != -1)
						sb.append('O');
					else
						sb.append('.');
				}sb.append("\n");
			}
			System.out.print(sb.toString());
		}
	
	}

	private static void fire(Queue<Bomb> que) {

		while(!que.isEmpty()) {
			Bomb b = que.poll();
			int r = b.r;
			int c = b.c;
			
			for(int d = 0; d < 5; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(!check(nr,nc)) continue;
				
				map[nr][nc] = -1;
			}
		}
		
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

}
class Bomb{
	int r;
	int c;
	public Bomb(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}