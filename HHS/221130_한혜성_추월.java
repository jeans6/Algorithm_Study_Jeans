package study_jeans;

import java.io.*;
import java.util.*;

public class Main_BOJ_2002_추월 {

	static int N;
	static int answer;
	static HashMap<String, Integer> car;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		car = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			car.put(str, i);
		}
		
		int [] outCar = new int[N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			int inNum = car.get(str);
			outCar[i] = inNum;
		}
		
		for(int i = 0; i < N-1; i++) {
			for(int j = i+1; j < N; j++) {
				if(outCar[i] > outCar[j]) {
					answer++;
					break;
				}
			}
		}
		
		
		bw.write(String.valueOf(answer));
		bw.close();
		
	}

}
