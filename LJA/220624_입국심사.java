import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        // Arrays.sort(times);
        
        long start, mid, end;
        start = 0;
        end = Long.MAX_VALUE;
        long sum;
        
        while(start <= end) {
            mid = (start + end) / 2; // 중간 시간 찾아냄
            sum = 0;
            
            // mid 시간동안 몇 명을 검사할 수 있는지 체크
            for(int i = 0; i < times.length; i++) {
                sum += mid/times[i];
                if(sum >= n) break; // n 사람들을 다 검사할 수 있으면 break
            }
            
            if(n > sum) start = mid+1; // n이 더크면 시간이 더 필요한거
            else { // 그게아니면 시간 줄이기
                end = mid-1;
                answer = Math.min(answer, mid);
            }
        }
        
        return answer;
    }
}