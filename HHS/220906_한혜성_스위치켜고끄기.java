import java.io.*;
import java.util.*;

public class Main_BOJ_1244_스위치켜고끄기 {

	static int N, T;
	static int [] light;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
	
		N = Integer.parseInt(br.readLine());
		
		light = new int[N];
		
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++)
			light[i] = Integer.parseInt(token.nextToken());
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			token = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(token.nextToken());
			int num = Integer.parseInt(token.nextToken());
			
			if(s == 1) { // 남학생
				for(int i = 0; i < N; i++) {
					if((i+1) % num == 0)
						light[i] = (light[i]+1) % 2;
				}
			}
			else { //여학생
				int l = num-2;
				int r = num;
				light[num-1] = (light[num-1]+1) % 2;
				while(true) {
					if(l < 0 || r >= N || light[l] != light[r])
						break;
					if(light[l] == light[r]) {
						light[l] = (light[l]+1) % 2;
						light[r] = (light[r]+1) % 2;
						l--;
						r++;
					}
				}
			
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(light[i] + " ");
			if((i+1) % 20 == 0)
				sb.append("\n");
		}
		System.out.print(sb.toString());
		
	}

}
