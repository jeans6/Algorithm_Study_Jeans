package HHS;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> spy = new HashMap<>();
        //의상 종류별로 (count1+1) * (count2+1) * (count3+1)... -1 하면 끝

        //의상 종류별로 개수 세어서 넣기
        for(int i = 0; i < clothes.length; i++){
            String clo = clothes[i][1];
            if(spy.containsKey(clo)){
                spy.put(clo, spy.get(clo)+1);
            }else{
                spy.put(clo, 1);
            }
        }
        
        //각 값+1 들의 곱을 구한 후 -1(아무것도 안 입을 경우)
        for(int count : spy.values()){
            answer *= (count+1);
        }
        
        return answer-1;
    }
}
