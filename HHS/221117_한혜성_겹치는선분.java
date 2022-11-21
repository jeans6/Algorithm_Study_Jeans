import java.io.*;
import java.util.*;

public class Main_BOJ_1689_겹치는선분 {

	static int N;
	static ArrayList<LineNum> line;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer token;
		line = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(token.nextToken());
			int e = Integer.parseInt(token.nextToken());
			
			line.add(new LineNum(s,1));
			line.add(new LineNum(e,-1));
		}
		
		Collections.sort(line);
		int count = 0;
		for(int i = 0; i < line.size(); i++) {
			count += line.get(i).value;
			answer = Math.max(answer, count);
		}
		
		bw.write(String.valueOf(answer));
		bw.close();
		
	}

}
class LineNum implements Comparable<LineNum>{
	int num;
	int value;
	public LineNum(int num, int value) {
		super();
		this.num = num;
		this.value = value;
	}
	@Override
	public int compareTo(LineNum o) {
		int first = this.num - o.num;
		if(first == 0) return this.value - o.value;
		return first;
	}
}
