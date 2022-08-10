import java.util.*;

class Solution {
    int row, col;
    // 상좌하우
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    boolean[][][] visited;
    
    public int[] solution(String[] grid) {
        List<Integer> list = new ArrayList<>();
        row = grid.length;
        col = grid[0].length();
        
        visited = new boolean[row][col][4];
        // 상하좌우로 다 들어감
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                for(int d = 0; d < 4; d++) {
                    if(!visited[i][j][d]) list.add(light(grid, i, j, d));
                }
            }
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) answer[i] = list.get(i);
        return answer;
    }
    
    int light(String[] grid, int r, int c, int d) {
        int cnt = 0; // 이동거리
        while(true) {
            if(visited[r][c][d]) break;
            cnt++;
            visited[r][c][d] = true;
            
            if(grid[r].charAt(c) == 'L') d = (d==0? 3 : d-1); // 좌회전
            else if(grid[r].charAt(c) == 'R') d = (d==3? 0 : d+1);
            
            r = (r+dr[d]+row) % row;
            c = (c+dc[d]+col) % col;
        }
        return cnt;
    }
}

// 참고 : https://jisunshine.tistory.com/175