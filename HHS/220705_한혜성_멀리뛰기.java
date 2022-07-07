import java.util.*;

class Solution {
    static long[] answer;
    
    public long solution(int n) {
        
        //dp로 풀기
        answer = new long[n+1];
        answer[0] = 1;
        answer[1] = 1;
        
        for(int i = 2; i <= n; i++){
            //각 단계마다 나눠줘야함
            answer[i] = (answer[i-1] + answer[i-2]) % 1234567;
        }
        
        return answer[n];
    }
    
}