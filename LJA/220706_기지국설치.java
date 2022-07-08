import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1; // 시작 좌표
        int range = w+w+1; // 전파의 범위
        
        for(int i = 0; i < stations.length; i++) {
            // 기지국이 있는 곳에서 -w-1하면 전파가 닿지 않는 곳의 마지막 인덱스
            int end = stations[i]-w-1;
            // 전파가 닿지 않는 곳의 범위 / range를 올림하면 기지국 설치개수
            answer += Math.ceil((double)(end-start+1)/range);
            // 인덱스 옮겨줌
            start = stations[i]+w+1;
        }
        if(start <= n) answer += Math.ceil((double)(n-start+1)/range);
        return answer;
    }
}