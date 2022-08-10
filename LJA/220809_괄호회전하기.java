import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            // 괄호 짝이 맞으면 +1
            if(isCorrect(s)) answer++;
            // 문자열 우측으로 하나씩 밀기
            s = s.charAt(s.length()-1) + s.substring(0, s.length()-1);
        }
        return answer;
    }
    
    boolean isCorrect(String str) {
        // 첫번째 문자열이 )]} 중 하나라면 올바른 괄호가 될 수 X
        char c = str.charAt(0);
        if(")]}".contains(String.valueOf(c))) return false;
        // 스택을 이용해 괄호짝 검사
        Stack<Character> stack = new Stack<>();
        stack.push(c);
        for(int i = 1; i < str.length(); i++) {
            c = str.charAt(i);
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            char top = stack.peek();
            if((c == ')' && top == '(') ||
               (c == '}' && top == '{') ||
               (c == ']' && top == '[')) stack.pop();
            else stack.push(c);
        }
        if(stack.size() > 0) return false;
        return true;
    }
}