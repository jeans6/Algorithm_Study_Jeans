import java.io.*;
import java.util.*;

public class Main_BOJ_16967_배열복원하기 {

	static int H, W, X, Y;
	static int [][] map;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] size = br.readLine().split(" ");
		
		H = Integer.parseInt(size[0]);
		W = Integer.parseInt(size[1]);
		X = Integer.parseInt(size[2]);
		Y = Integer.parseInt(size[3]);
		
		map = new int[H][W];
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < H; i++) {
			String [] str = br.readLine().split(" ");
			for(int j = 0; j < W; j++) {
				if(i >= X && j >= Y) 
					map[i][j] = Integer.parseInt(str[j]) - map[i-X][j-Y];
				else 
					map[i][j] = Integer.parseInt(str[j]);

				bw.write(String.valueOf(map[i][j] + " "));
			}bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
