class Solution {
    static int min = Integer.MAX_VALUE;
    
    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return min>8?-1:min;
    }
    
    public void dfs(int N, int number, int cal, int cnt) {
        if(cnt > 8) return; // cnt가 8보다 크면 끝
        if(cal == number) { // 숫자를 표현할 수 있으면
            min = Math.min(min, cnt);
            return;
        }
        // 5, 55, 555, 5555에 해당하는 연산 필요
        int temp = 0;
        for(int i = 0; i < 8-cnt; i++) {
            if(cnt + i >= 8) continue;
            temp = temp*10+N;
            dfs(N, number, cal+temp, cnt+1+i);
            dfs(N, number, cal-temp, cnt+1+i);
            dfs(N, number, cal/temp, cnt+1+i);
            dfs(N, number, cal*temp, cnt+1+i);
        }
    }
}