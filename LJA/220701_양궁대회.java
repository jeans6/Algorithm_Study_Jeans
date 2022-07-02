import java.util.*;

class Solution {
    static int max = 1;
    static int[] answer = {-1};
    
    public int[] solution(int n, int[] info) {
        // 모든 경우의 수를 탐색하기 위해 dfs 사용
        dfs(0, n, info, new int[info.length]);
        return answer;
    }
    
    public static void dfs(int cnt, int n, int[] info, int[] ryanInfo) {
        if(cnt == n) { // 화살 다 쏘면 점수 계산
            int apeach = 0;
            int ryan = 0;
            for(int i = 0; i < info.length; i++) {
                if(info[i] == 0 && ryanInfo[i] == 0) continue;
                if(info[i] >= ryanInfo[i]) apeach += 10-i;
                else ryan += 10-i;
                // 원래 이 if문 썼다가 시간 초과나서 위에껄로 바꿨더니 통과됨..
                // if((info[i] > ryanInfo[i]) || (info[i] == ryanInfo[i] && info[i] !=0)) apeach += 10-i;
                // else if(info[i] < ryanInfo[i]) ryan += 10-i;
            }
            if(ryan-apeach >= max) { // 점수차가 가장 클 경우 각각에 저장
                max = ryan-apeach;
                answer = ryanInfo.clone();
            }
            return;
        }
        
        for(int i = 0; i < info.length; i++) {
            if(ryanInfo[i] > info[i]) break; // 라이언 점수가 어피치보다 이미 크면 더 볼 필요 X
            ryanInfo[i]++;
            dfs(cnt+1, n, info, ryanInfo);
            ryanInfo[i]--;
        }
    }
}