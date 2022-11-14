import java.io.*;
import java.util.*;

public class Main_BOJ_22233_가희와키워드 {

	static int N, M;
	static HashSet<String> memo;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		memo = new HashSet<>();
		StringTokenizer token;
		token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		for(int n = 0; n < N; n++)
			memo.add(br.readLine());

		for(int m = 0; m < M; m++) {
			String [] str = br.readLine().split(",");
			for(int i = 0; i < str.length; i++) {
				if(memo.contains(str[i]))
					memo.remove(str[i]);
			}
			bw.write(String.valueOf(memo.size())+"\n");
		}
		bw.close();
	}

}
