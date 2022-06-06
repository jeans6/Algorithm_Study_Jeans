import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.get(clothes[i][1])==null?1:map.get(clothes[i][1])+1);
        }
        int answer = 1;
        for(String key : map.keySet()) {
            answer *= map.get(key)+1;
        }
        return answer-1;
    }
}