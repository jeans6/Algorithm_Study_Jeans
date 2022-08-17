package HHS;

import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> game = new HashSet<>();
        for(int i = 0; i < words.length; i++){
            if(game.contains(words[i])){
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            if(i >= 1){
                char end = words[i-1].charAt(words[i-1].length()-1);
                char start = words[i].charAt(0);
                if(end != start){
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;
                    break;
                }
            }
            game.add(words[i]);
                
        }
        
        return answer;
    }
}