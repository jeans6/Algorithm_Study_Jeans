package HHS;

import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book){
        boolean answer = true;
        // 전화번호 정렬한 후 
        // 순서대로 돌면서 자신의 뒤만 체크
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length-1; i++){
            String num = phone_book[i];
            String num2 = phone_book[i+1];
            //자신보다 길이가 더 길고 자신으로 시작하는 숫자이면 answer 변경후 break
            if(num.length() < num2.length() && num2.startsWith(num)){
                answer = false;
                break;
            }
        }
        return answer;
    }
    
}
