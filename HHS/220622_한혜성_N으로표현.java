import java.util.*;

class Solution {
    
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int N, int number) {

        //dfs로 그냥 다 돌리기
        // + - * / 네가지 다 하고
        //각 숫자들 8 88 888 8888 등 해보기
        //카운트가 9이상 시 -1 return
        
        dfs(N, number, 0, 0); //N, number, count, now
        
        if(answer == Integer.MAX_VALUE)
            answer = -1;
        return answer;
    }
    private static void dfs(int N, int number, int count, int now){
        // 카운트 넘어가면 나가
        if(count >= 9)
            return;
        
        //만드려는 숫자와 같아지면 answer와 값 비교
        if(number == now){
            answer = Math.min(answer, count);
            return;
        }
        
        int num = N;
        for(int i = 0; i < 8; i++){
            
            dfs(N, number, count+1+i, now + num);
            dfs(N, number, count+1+i, now - num);
            dfs(N, number, count+1+i, now * num);
            dfs(N, number, count+1+i, now / num);
            
            // 8 88 888 8888만들기
            num = (10 * num) + N;
        }
        
        
    }
}