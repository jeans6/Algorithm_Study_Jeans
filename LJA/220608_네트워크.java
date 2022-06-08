class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 각 컴퓨터가 연결되어 있는지 여부 확인
        boolean[] connected = new boolean[n];
        // 연결되지 않은 컴퓨터의 연결 체크
        for(int i = 0; i < n; i++) {
            if(!connected[i]) {
                answer++;
                dfs(i, connected, n, computers);
            }
        }
        return answer;
    }
    
    public void dfs(int cur, boolean[] connected, int n, int[][] computers) {
        connected[cur] = true;
        // 연결체크
        for(int i = 0; i < n; i++) {
            if(!connected[i] && computers[cur][i] == 1) {
                dfs(i, connected, n, computers);
            }
        }
    }
}