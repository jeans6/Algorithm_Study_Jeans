import java.util.*;

class Solution {
    public int solution(int n) {
        int add = 0;
        int initCount = 0;
        
        //1씩 더해서 2로 나눈 나머지들의 개수 확인하고 같으면 바로 출력
        while(true){
            int count = 0;
            
            int answer = n + add;
            
            while(answer / 2 > 0){
                //나머지 1인 애들 개수 세기
                if(answer % 2 == 1)
                    count++;
                answer /= 2;
                
                //초기값의 1 개수 
                if(add == 0)
                    initCount = count;
            }
            
            //더한 값과 초기값의 1개수가 같으면 멈추기
            if(add != 0 && initCount == count)
                break;
            
            add++;
        }
        
        return n + add;
    }
}