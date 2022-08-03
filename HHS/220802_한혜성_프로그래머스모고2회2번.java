import java.util.*;

class Solution {
    static int answer;

    public int solution(int[] topping) {

        HashMap<Integer, Integer> total = new HashMap<>();
        HashMap<Integer, Integer> cheol = new HashMap<>();
        
        for(int i = 0; i < topping.length; i++){
            int num = topping[i];
            if(total.containsKey(num))
                total.put(num, total.get(num)+1);
            else
                total.put(num, 1);
        }//전체값 다 넣어놓기
        int cnt = total.size();

        for(int i = 0; i < topping.length; i++){
            int num = topping[i];
            cheol.put(num, 1);
            
            int totalCnt = total.get(num);
            total.put(num, totalCnt-1);    
            
            if(totalCnt == 1) cnt--;
            if(cnt == cheol.size()) answer++;

        }

        return answer;
    }
}