package HHS;

import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book){
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length-1; i++){
            String num = phone_book[i];
            String num2 = phone_book[i+1];
            if(num.length() < num2.length() && num2.startsWith(num)){
                answer = false;
                break;
            }
        }
        return answer;
    }
    
}
