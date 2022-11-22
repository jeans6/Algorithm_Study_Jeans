import java.io.*;
import java.util.*;

public class Main_BOJ_2872_우리집엔도서관이있어 {

	static int N;
	static int [] arr;
	static int answer;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		for(int i = 0; i < N; i++)
			arr[Integer.parseInt(br.readLine())] = i;
		
		answer = N-1;
		int idx = arr[N];
		int val = N-1;
		for(int i = idx; i > 0; i--) {
			if(arr[val] < idx) {
				answer--;
				idx = arr[val];
				val--;
			}
		}
		
		bw.write(String.valueOf(answer));
		bw.close();
	}

}
