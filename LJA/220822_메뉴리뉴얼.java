import java.util.*;
import java.util.stream.*;

class Solution {
    Map<String, Integer> setMap;
    int max;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        // course[i]개 뽑는 조합 만들기
        for(int i = 0; i < course.length; i++) { 
            setMap = new HashMap<>();
            max = 0;
            for(int j = 0; j < orders.length; j++) {
                if(course[i] <= orders[j].length()) 
                    perm(0, 0, course[i], orders[j], "", new boolean[orders[j].length()]);
            }
            // 손님이 2번 이상 주문하고, 가장 인기있는 경우에만 결과리스트에 저장
            if(max > 1) {
                for(String key : setMap.keySet()) {
                    if(setMap.get(key) == max) {
                        result.add(key);
                    }
                }
            }
        }
        Collections.sort(result);
        return result.toArray(new String[result.size()]);
    }
    
    void perm(int start, int cnt, int N, String order, String set, boolean[] visited) {
        if(cnt == N) {
            if(set.length() > 1) {
                set = Stream.of(set.split(""))
                        .sorted()
                        .collect(Collectors.joining());
                setMap.put(set, setMap.getOrDefault(set, 0)+1);
                max = Math.max(max, setMap.get(set));
            }
            return;
        }
        for(int i = start; i < order.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            perm(i, cnt+1, N, order, set+order.charAt(i), visited);
            visited[i] = false;
        }
    }
}