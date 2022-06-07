package HHS;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        ArrayList<Integer> result = new ArrayList<>();
        
        int [] pr = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++){
            //각 걸리는 날짜 계산하여 pr에 넣어주기
            int time = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0)
                time +=1;
            pr[i] = time;
        }
        
        int count = 1;
        int temp = pr[0];
        //pr돌면서 앞의 값보다 작은 경우에만 카운트 올리고 어레이리스트에 올려주기
        for(int i = 1; i < progresses.length; i++){
            if(pr[i] <= temp){
                count++;
            }else{
                temp = pr[i];
                result.add(count);
                count = 1;
            }
        }
        result.add(count);
        
        int [] answer = new int[result.size()]; 
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}