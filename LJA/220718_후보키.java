import java.util.*;

class Solution {
    static int answer;
    static List<List<Integer>> list;
    
    public int solution(String[][] relation) {
        list = new ArrayList<>();
        // 유일성을 만족하는 모든 집합을 찾음
        isUnique(0, new boolean[relation[0].length], relation);
        
        // 최소성을 만족하는지 찾기 위해 집합 사이즈가 작은순으로 정렬
        Collections.sort(list, (o1, o2) -> o1.size()-o2.size());
        for(int i = 0; i < list.size(); i++) {
            int size = list.get(i).size();
            for(int j = i+1; j < list.size(); j++) {
                int duplicateCnt = 0;
                for(int s = 0; s < size; s++) {
                    // 이 부분에서 많이 헤맸다...ㅎ
                    // 만약 [0, 2], [0, 1, 2] 이런식으로 있을 때를 대비해 contains를 사용해 비교!
                    if(list.get(j).contains(list.get(i).get(s))) duplicateCnt++;
                }
                if(duplicateCnt == size) {
                    list.remove(j);
                    j--;
                }
            }
        }
        return list.size();
    }
    
    
    public static void isUnique(int cnt,  boolean[] visited, String[][] relation) {
        if(cnt == visited.length) {
            // 만들어질 수 있는 집합 넣음
            Set<String> keySet = new HashSet<>();
            for(int i = 0; i < relation.length; i++) {
                StringBuffer sb = new StringBuffer();
                for(int t = 0; t < visited.length; t++) {
                    if(visited[t]) {
                        sb.append(relation[i][t]+" ");
                    }
                }
                keySet.add(sb.toString());
            }
            // 집합 사이즈가 테이블의 row개수와 같으면 중복이 없는 것
            if(keySet.size() == relation.length) {
                List<Integer> indexList = new ArrayList<>();
                for(int i = 0; i < visited.length; i++) {
                    if(visited[i]) indexList.add(i);
                }
                list.add(indexList);
            }
            return;
        }
        visited[cnt] = true;
        isUnique(cnt+1, visited, relation);
        visited[cnt] = false;
        isUnique(cnt+1, visited, relation);
    }
}