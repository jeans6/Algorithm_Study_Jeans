import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> stack = new Stack<>();
		List<Character> list = new ArrayList<Character>();
		int idx = 0;
		int num = 1;
		while(num <= N) {
			if(!stack.isEmpty() && arr[idx] == stack.peek()) {
				stack.pop();
				idx++;
				list.add('-');
			} else {
				stack.push(num++);
				list.add('+');
			}
		}
		boolean isSame = true;
		while(!stack.isEmpty()) {
			if(!stack.isEmpty() && arr[idx++] == stack.peek()) {
				stack.pop();
				list.add('-');
			} else {
				isSame = false;
				break;
			}
		}
		
		if(!isSame) System.out.println("NO");
		else for(int i = 0; i < list.size(); i++) System.out.println(list.get(i));
	}
}
