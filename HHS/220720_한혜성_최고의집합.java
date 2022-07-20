import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        //산술기하평균에 의해 곱이 최대가 나오려면 숫자간의 차이가 적어야 함
        //n으로 나누고 나눈 몫이 0이 나오면 -1 출력
        //그게 아니라면 몫 일단 나눠주고 나머지들 처리해주기
        int num = s / n;
        int [] answer;
        if(num == 0){
            answer = new int[1];
            answer[0] = -1; 
        }
        
        else{
            answer = new int[n];
            int mod = s % n;
            for(int i = 0; i < n; i++){
                if(i < mod)
                    answer[i]++;
                answer[i] += num;
            }
            Arrays.sort(answer);
        }
            
        return answer;
    }
}