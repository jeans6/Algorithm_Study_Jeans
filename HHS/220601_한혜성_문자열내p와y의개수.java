package HHS;

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pNum = 0;
        int yNum = 0;
        
        //s돌면서 개수 파악, answer리턴
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P')
                pNum++;
            else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y')
                yNum++;
            
        }
        if(pNum != yNum) answer = false; 

        return answer;
    }
}