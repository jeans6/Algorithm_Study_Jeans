package HHS;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        //HashMap에 참여자들 넣고 완주자들의 이름을 제거한 후 value가 1이면 출력
        
        HashMap<String, Integer> players = new HashMap<String, Integer>();
        
        for(int i = 0; i < participant.length; i++){
            if(players.containsKey(participant[i])){
                int count = players.get(participant[i]);
                players.put(participant[i], count+1);
            }
            else    
                players.put(participant[i], 1);
        }
        
        for(int i = 0; i < completion.length; i++){
            int count = players.get(completion[i]);
                players.put(completion[i], count-1);
        }
        String answer = "";
        
        for(String key : players.keySet()){
            if(players.get(key) != 0){
                answer = key;
                break;
            }
        }
        
        
        return answer;
    }
}