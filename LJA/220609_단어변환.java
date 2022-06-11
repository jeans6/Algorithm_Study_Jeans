import java.util.*;

class Solution {
    static int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        dfs(0, begin, target, words, new boolean[words.length]);
        return answer;
    }
    
    public void dfs(int cnt, String current, String target, String[] words, boolean[] visited) {
        // 현재 단어가 target과 같아지면 끝
        if(current.equals(target)) {
            answer = cnt;
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(visited[i]) continue;
            // 현재 단어와 변환될 단어가 1개의 알파벳만 다른지 확인
            if(checkWordCount(current, words[i])) {
                visited[i] = true;
                dfs(cnt+1, words[i], target, words, visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean checkWordCount(String a, String b) {
        int cnt = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == b.charAt(i)) cnt++;
        }
        if(cnt == a.length()-1) return true;
        return false;
    }
}