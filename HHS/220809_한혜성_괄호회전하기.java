import java.util.*;
class Solution {
    static int answer;
    
    public int solution(String s) {
        
        //움직이고 stack에 넣어서 확인해보기
        StringBuilder sb = new StringBuilder();
        
        sb.append(s+s);

        for(int i = 0; i < s.length()-1; i++){
            String str = sb.substring(i, i + s.length());
            check(str);
        }
        
        return answer;
    }
    public static void check(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            stack.push(str.charAt(i));
        }
        Stack<Character> subStack = new Stack<>();
        subStack.push(stack.pop());
        
        while(!stack.isEmpty()){
            if(stack.size()!=0 && subStack.size()!=0 &&( 
              (subStack.peek() == ')' && stack.peek() == '(') ||
              (subStack.peek() == '}' && stack.peek() == '{') ||
              (subStack.peek() == ']' && stack.peek() == '[') )){
                stack.pop();
                subStack.pop();
            }
            else 
                subStack.push(stack.pop());
        }
        if(subStack.size()==0)
            answer++;
    }
}