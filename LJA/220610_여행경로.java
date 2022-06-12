import java.util.*;

class Solution {
    public static List<String[]> list;
    
    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        dfs(0, "ICN", tickets, new boolean[tickets.length], new String[tickets.length+1]);
        // 오름차순으로 정렬
        Collections.sort(list, (s1, s2) -> Arrays.toString(s1).compareTo(Arrays.toString(s2)));
        return list.get(0);
    }
    
    public void dfs(int cnt, String prev, String[][] tickets, boolean[] visited, String[] arr) {
        // 항공권을 모두 다 사용하면 끝
        if(cnt == tickets.length) {
            arr[cnt] = prev;
            // list.add(arr) 하면 주소 복사가 이루어져서 기존 값들도 모두 바뀜
            // 따라서 arr.clone()로 깊은 복사를 해줘야함...!
            list.add(arr.clone());
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            // 방문한 적 없거나 이전 도착지와 다음 출발지가 같아야함
            if(visited[i] || !prev.equals(tickets[i][0])) continue;
            visited[i] = true;
            arr[cnt] = prev;
            dfs(cnt+1, tickets[i][1], tickets, visited, arr);
            visited[i] = false;
        }
    }
}