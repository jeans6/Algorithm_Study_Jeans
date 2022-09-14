import java.io.*;
import java.util.*;

public class Main_BOJ_2138_전구와스위치 {

	static int N;
	static int [] light1;
	static int [] light2;
	static int [] result;
	static int answer = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		light1 = new int[N];
		light2 = new int[N];
		result = new int[N];
		
		String str1 = br.readLine();
		for(int i = 0; i < N; i++) {
			light1[i] = str1.charAt(i)-'0';
			light2[i] = str1.charAt(i)-'0';
		}
		
		String str2 = br.readLine();
		for(int i = 0; i < N; i++)
			result[i] = str2.charAt(i)-'0';
		
		//첫번째 인덱스를 누르냐 마냐에 따라 결과가 나뉨
		//누르고 시작하거나 안누르고 시작하는 두가지 경우에 대해서만 보면 될 듯

		onoff(light1, 0);

		onoff(light2, 1);
		
		if(answer == Integer.MAX_VALUE)
			answer = -1;
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}


	private static void onoff(int [] lgt, int count) {

		if(count == 1){
			lgt[0] = (lgt[0]+1) % 2;
			lgt[1] = (lgt[1]+1) % 2;
		}
		
		int i = 1;
		
		while(i < N) {
			
			if(lgt[i-1] != result[i-1]) {
				lgt[i-1] = result[i-1];
				lgt[i] = (lgt[i] +1) % 2; 
				
				if(i < N-1)
					lgt[i+1] = (lgt[i+1]+1) % 2; 
				
				count++;
			}
			i++;
			
		}
		
		if(lgt[N-1] == result[N-1])
			answer = Math.min(answer, count);
	}

}
