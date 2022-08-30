import java.util.*;

class Solution {
    String[] arr = {"A", "E", "I", "O", "U"};
    List<String> list;
    
    public int solution(String word) {
        list = new ArrayList<>();
        int answer = 0;
        
        dfs(0, "");
        Collections.sort(list);
        answer = list.indexOf(word)+1;
        
        return answer;
    }
    
    void dfs(int cnt, String str) {
        if(cnt >= 5) return;
        for(int i = 0; i < arr.length; i++) {
            list.add(str+arr[i]);
            dfs(cnt+1, str+arr[i]);
        }
    }
}