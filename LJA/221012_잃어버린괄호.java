import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1541 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = 0;
		int start = 0;
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < str.length(); i++) {
			String c = String.valueOf(str.charAt(i));
			if("+-".contains(c)){
				list.add(str.substring(start, i));
				list.add(c);
				start = i+1;
			}
			if(i == str.length()-1) {
				list.add(str.substring(start));
			}
		}
		int min = 0;
		boolean isMinus = false;
		for(int i = 0; i < list.size(); i++) {
			String c = list.get(i);
			if(c.equals("-") || c.equals("+")){
				if(c.equals("-")) isMinus = true;
			} else {
				if(!isMinus) min += Integer.parseInt(c);
				if(isMinus) min -= Integer.parseInt(c);
			}
		}
		System.out.println(min);
	}

}
