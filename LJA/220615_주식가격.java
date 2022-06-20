import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer[]> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++) {
            if(stack.isEmpty()) {
                // 스택이 비어있는 경우 바로 넣어줌
                stack.push(new Integer[]{prices[i], i});
            } else {
                // 하락인 경우 = 스택의 top과 들어가려는 값 비교 
                while(!stack.isEmpty() && stack.peek()[0] > prices[i]) {
                    // 현재 넣으려는 idx값-top의 idx값을 해주면 그동안 얼마나 유지했는지 계산 가넝
                    answer[stack.peek()[1]] = i - stack.pop()[1];
                }
                stack.push(new Integer[]{prices[i], i});
            }
        }
        // 스택에 남아있는 애들 = 상승 유지한 애들
        while(!stack.isEmpty()) {
            int idx = stack.pop()[1];
            answer[idx] = prices.length - idx - 1;
        }
        return answer;
    }
}