import java.util.*;
class Solution {
    static ArrayList<String> dict;
    static String [] alpha = {" ", "A", "E", "I", "O", "U"};
    
    public int solution(String word) {
            
        dict = new ArrayList<>();
        dfs(0, "");
        
        Collections.sort(dict);
        int len = word.length();
        if(len != 5){
            for(int i = len; i < 5; i++)
                word += " ";
        }
        int answer = dict.indexOf(word)+1;
        
        return answer;
    }
    private static void dfs(int cnt, String str){
        if(cnt == 5){
            dict.add(str);
            return;
        }
        for(int i = 0; i < 6; i++){
            if(cnt == 0 && i == 0) continue;
            if(cnt > 0 && str.charAt(cnt-1) == ' ' && i != 0) continue;
            
            dfs(cnt+1, str+alpha[i]);
        }
    }
}