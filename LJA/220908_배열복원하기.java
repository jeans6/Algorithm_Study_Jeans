import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int H, W, X, Y;
	static int[][] B;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		B = new int[H+X][W+Y];
		for(int i = 0; i < H+X; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W+Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(i >= X && j >= Y) B[i][j] -= B[i-X][j-Y];
			}
		}
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				System.out.print(B[i][j]+" ");
			}
			System.out.println();
		}
	}
}