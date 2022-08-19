import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> calMap = new HashMap<>();
        int endTime = 23*60+59;
        
        for(int i = 0; i < records.length; i++) {
            String[] tempArr = records[i].split(" ");
            String[] timeArr = tempArr[0].split(":");
            String carNum = tempArr[1];
            int time = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
            
            if(map.containsKey(carNum)) { // 출차
                int sum = time - map.get(carNum);
                calMap.put(carNum, calMap.getOrDefault(carNum, 0) + sum);
                map.remove(carNum);
            } else { // 입차
                map.put(carNum, time);
            }
        }
        
        // 출차 기록 없는거 처리
        for(String key : map.keySet()) {
            calMap.put(key, calMap.getOrDefault(key, 0) + endTime - map.get(key));
        }
        
        int[] answer = new int[calMap.size()];
        List<String> sortList = new ArrayList<>(calMap.keySet());
        Collections.sort(sortList);
        // 요금 계산
        for(int i = 0; i < sortList.size(); i++) {
            String key = sortList.get(i);
            answer[i] = fees[1];
            int time = calMap.get(key) - fees[0];
            if(time > 0) { // 기본 시간 초과
                answer[i] += (time/fees[2])*fees[3];
                if(time%fees[2] != 0) answer[i] += fees[3];
            }
        }
        
        return answer;
    }
    
}