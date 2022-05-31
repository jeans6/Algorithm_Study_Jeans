import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 동명이인이 있을 수도 있기 때문에 이름, 참가자수 형태로 데이터를 저장해야 할 것 같아 map을 사용
        Map<String, Integer> map = new HashMap<>();
        // 모든 참가자를 map에 넣음
        for(String name : participant) {
            map.put(name, map.get(name)==null?1:map.get(name)+1);
        }
        // 모든 완주자를 map에서 뺌
        for(String name : completion) {
            map.put(name, map.get(name)-1);
        }
        // 완주하지 못한 사람은 value값이 0보다 큼
        String answer = "";
        for(String name : map.keySet()) {
            if(map.get(name) > 0) {
                answer = name;
                break;
            }
        }
        return answer;
    }
}