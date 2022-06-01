package HHS;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        //tc 13, 14 -> 정렬되어 있지 않은 경우 고려
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        //있으면 2, 체육복 없으면 1
        int [] PE = new int[n+1];
        for(int i = 0; i < lost.length; i++){
            PE[lost[i]] = 1;
        }
        for(int i = 0; i < reserve.length; i++){
            if(PE[reserve[i]] == 1){//자기꺼 잃어버리고 여분으로 가져온 사람 해결 가능
                PE[reserve[i]] = 0;
                answer++;
            }
            else PE[reserve[i]] = 2;
        } 
        
        for(int i = 0; i < lost.length; i++){
            int a = lost[i];
            if(a-1 > 0 && PE[a] == 1 && PE[a-1] == 2){
                PE[a-1] = 0;
                answer++;
            }else if(a+1 <= n && PE[a] == 1 && PE[a+1] == 2){
                PE[a+1] = 0;
                answer++;
            }
        }
        
        
        return answer;
    }
}