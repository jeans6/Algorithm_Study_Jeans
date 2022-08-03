import java.util.*;
class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        while(n > 0){
            int mod = n % 3;
            if(mod == 0){
                n = (n-1)/3;
                mod = 4;                
            }else
                n /= 3;
            stack.push(mod);
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}