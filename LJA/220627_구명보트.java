import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 배열 내림차순으로 정렬
        Arrays.sort(people);
        
        int answer = 0;
        int idx = 0;
        int lastIdx = people.length-1;
        while(idx <= lastIdx) {
            if(people[idx] + people[lastIdx] <= limit) {
                // 둘 다 탈 수 있으면
                idx++;
                lastIdx--;
                answer++;
            } else {
                // 같이 못탄다는거 = lastIdx가 혼자타야한다는뜻
                lastIdx--;
                answer++;
            }
        }
        return answer;
    }
}