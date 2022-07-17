import java.util.*;

class Solution {
    // 동남서북
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    // 상대 진영의 위치
    static int er, ec;
    
    public int solution(int[][] maps) {
        er = maps.length-1;
        ec = maps[0].length-1;
        bfs(0, 0, maps);
        return maps[er][ec]==1?-1:maps[er][ec];
    }
    
    public static void bfs(int r, int c, int[][] maps) {
        // 큐에 현재 시작 좌표 넣음
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            // 좌표 사방에 갈 수 있는 방향이 있으면 큐에 넣고
            // 직전 거리+1 해 줌
            for(int d = 0; d < 4; d++) {
                int nr = pos[0]+dr[d];
                int nc = pos[1]+dc[d];
                if(nr < 0 || nc < 0 || nr > er || nc > ec) continue;
                if(maps[nr][nc] != 1) continue;
                queue.offer(new int[]{nr, nc});
                maps[nr][nc] = maps[pos[0]][pos[1]]+1;
            }
        }
        
    }
}