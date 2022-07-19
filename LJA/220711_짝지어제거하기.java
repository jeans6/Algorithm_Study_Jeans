import java.util.*;

class Solution
{
    public int solution(String s)
    {
        // 비교하려는 문자는 우선 스택에 push
        // 스택 젤 위에 값과 string 값을 비교해서 stack에서 pop해줌
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size()>0?0:1;
    }
}