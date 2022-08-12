import java.util.*;

class Solution {
    Map<String, List<Integer>> map;
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();
        
        for(int i = 0; i < info.length; i++) {
            String[] p = info[i].split(" ");
            makeSentence(p, "", 0); // subset을 통해 만들 수 있는 모든 경우의 수를 만듦
        }
        
        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        for(int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", ""); // map에 있는 형태와 맞춰줌
            String[] q = query[i].split(" ");
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }
        
        return answer;
    }
    
    void makeSentence(String[] p, String str, int cnt) {
        if(cnt == 4) {
            if(!map.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(p[4]));
            return;
        }
        makeSentence(p, str+"-", cnt+1);
        makeSentence(p, str+p[cnt], cnt+1);
    }
    
    int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;
        
        while(start <= end) {
            int mid = (start+end)/2;
            if(list.get(mid) < score) start = mid+1;
            else end = mid-1;
        }
        return list.size()-start;
    }
}

// 참고 https://jisunshine.tistory.com/153