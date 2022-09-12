import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[] arr = new int[N];
		String str = sc.nextLine();
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		
		Stack<Double> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if("+-*/".contains(String.valueOf(c))) {
				// 연산 후 결과 스택에 저장
				double num2 = stack.pop();
				double num1 = stack.pop();
				if(c == '+') stack.add(num1+num2);
				else if(c == '-') stack.add(num1-num2);
				else if(c == '*') stack.add(num1*num2);
				else if(c == '/') stack.add(num1/num2);
			} else {
				stack.add((double)arr[c-'A']);
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}