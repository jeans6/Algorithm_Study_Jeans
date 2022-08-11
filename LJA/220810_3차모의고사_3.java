import java.util.*;

class Solution {
    public int solution(int distance, int[][] scope, int[][] times) {
        int answer = distance;
        int N = scope.length;
        for(int i = 0; i < N; i++) {
            int time = times[i][0]+times[i][1];
            int start = scope[i][0] < scope[i][1] ? scope[i][0] : scope[i][1];
            int end = start + Math.abs(scope[i][0]-scope[i][1]);
            for(int j = start; j <= end; j++) {
                int curTime = j%time;
                if(curTime >= 1 && curTime <= times[i][0]) answer = Math.min(answer, j);
            }
        }
        return answer;
    }
}