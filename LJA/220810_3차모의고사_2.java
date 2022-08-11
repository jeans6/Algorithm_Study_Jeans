import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]);
        }

        int answer = 0;
        int first = 0;
        int last = first+3;
        while(last < list.size()) {
            if(list.get(first) == 1 && list.get(first+1) == 2 && list.get(first+2) == 3 && list.get(first+3) == 1) {
                answer++;
                list.remove(first);
                list.remove(first);
                list.remove(first);
                list.remove(first);
                first = (first-2 < 0 ? 0 : first-2);
            } else {
                first++;
            }
            last = first+3;
        }
        return answer;
    }
}