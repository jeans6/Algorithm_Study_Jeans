import java.util.*;
import java.io.*;

class Solution{
    public int solution(String s){
        int answer = 0;

        //스택에서 하나 넣고
        //하나 픽하면서 그 다음 문자와 같으면 그냥 뽑고
        //다르면 넣기
        char [] str = s.toCharArray();

        Stack<Character> stack = new Stack();
        
        stack.push(str[0]);
        for(int i = 1; i < str.length; i++){
            if(!stack.isEmpty() && stack.peek() == str[i])
                stack.pop();
            else
                stack.push(str[i]);
                
        }
        if(stack.size() == 0)        
            answer = 1;
        return answer;
    }
}