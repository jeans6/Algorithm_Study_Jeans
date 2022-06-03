class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(0, 0, numbers, target);
        return answer;
    }
    
    public static int dfs(int total, int cnt, int[] numbers, int target) {
        int answer = 0;
        // numbers 배열을 다 봄
        if(cnt >= numbers.length) {
            if(total == target) return 1;
            return 0;
        }
        // +, - 연산 수행
        answer += dfs(total+numbers[cnt], cnt+1, numbers, target);
        answer += dfs(total-numbers[cnt], cnt+1, numbers, target);
        return answer;
    }
}