import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static long answer;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int n = 0; n < N; n++) 
			pq.offer(Integer.parseInt(br.readLine()));
		
		answer = 0;
		
		while(pq.size()>1) {
			int num1 = pq.poll();
			int num2 = pq.poll();
			if(pq.size()>0)
				pq.offer(num1 + num2);
			answer+= num1+num2;
		}
		
		bw.write(String.valueOf(answer));
		bw.close();
		
	}

}
