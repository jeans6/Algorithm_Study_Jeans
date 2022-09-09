import java.io.*;
import java.util.*;

public class Main_BOJ_10655_마라톤1 {

	static int N;
	static int [][]map;
	static int [] dist;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][2];
		StringTokenizer token = null; 
		dist = new int[N];
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(token.nextToken());
			map[i][1] = Integer.parseInt(token.nextToken());
			if(i > 0) {
				dist[i] = Math.abs(map[i][0]-map[i-1][0]) + Math.abs(map[i][1] - map[i-1][1]);
				sum += dist[i];
			}
		}
		int answer = Integer.MAX_VALUE;
		for(int i = 1; i < N-1; i++) {
			int cal = sum - (dist[i]+dist[i+1]) + Math.abs(map[i-1][0]-map[i+1][0])+Math.abs(map[i-1][1]-map[i+1][1]);
			answer = Math.min(answer, cal);
		}
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

}
