import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 누가 누구를 신고했는지 Map에 저장
        // key는 String 타입으로 신고한 사람을 저장
        // value는 HashSet(중복제거)타입으로 신고당한 사람들 저장
        Map<String, Set<String>> map = new HashMap<>();
        for(int i = 0; i < report.length; i++) {
            String[] name = report[i].split(" ");
            Set<String> list = (map.get(name[0])==null?new HashSet<>() : map.get(name[0]));
            list.add(name[1]);
            map.put(name[0], list);
        }
        // 신고당한 횟수 저장
        Map<String, Integer> reportMap = new HashMap<>();
        for(String key : map.keySet()) {
            for(String value : map.get(key)) {
                reportMap.put(value, reportMap.get(value)==null?1:reportMap.get(value)+1);
            }
        }
        
        // 배열에 id_list순으로 출력을 위해 map에 id_list의 이름과 index를 저장
        Map<String, Integer> idxList = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            idxList.put(id_list[i], i);
        }
        
        // k번 이상 신고당한 사람을 신고한 사람을 찾아 answer++해줌
        int[] answer = new int[id_list.length];
        for(String reported : reportMap.keySet()) {
            if(reportMap.get(reported) >= k) {
                for(String key : map.keySet()) {
                    if(map.get(key).contains(reported)) {
                        answer[idxList.get(key)]++;
                    }
                }
            }
        }
        return answer;
    }
}