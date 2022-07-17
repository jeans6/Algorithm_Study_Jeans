class Solution {
    // 동남서북
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    // 최솟값 저장
    static int min = Integer.MAX_VALUE;
    // 상대 진영의 위치
    static int er, ec;
    
    public int solution(int[][] maps) {
        er = maps.length-1;
        ec = maps[0].length-1;
        dfs(1, 0, 0, maps, new boolean[er+1][ec+1]);
        return min==Integer.MAX_VALUE?-1:min;
    }
    
    public static void dfs(int cnt, int r, int c, int[][] maps, boolean[][] visited) {
        if(cnt > min) return;
        if(r == er && c == ec) {
            min = Math.min(min, cnt);
            return;
        }
        for(int d = 0; d < 4; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];
            if(nr < 0 || nc < 0 || nr > er || nc > ec) continue;
            if(maps[nr][nc] != 1 || visited[nr][nc]) continue;
            visited[nr][nc] = true;
            dfs(cnt+1, nr, nc, maps, visited);
            visited[nr][nc] = false;
        }
        
    }
}