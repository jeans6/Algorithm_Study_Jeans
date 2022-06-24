import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] board = new int[n][n];
        // 대전결과 넣어줌
        for(int i = 0; i < results.length; i++) {
            int winner = results[i][0]-1;
            int loser = results[i][1]-1;
            board[winner][loser] = 1;
            board[loser][winner] = -1;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && board[i][j] == 1) {
                    // i한테 진 j한테 진 사람들은 나한테 짐
                    bfs(i, j, board, new boolean[n][n]);
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(board[i][j] != 0) cnt++;
            }
            if(cnt == n-1) answer++; 
        }
        return answer;
    }
    
    public void bfs(int winner, int loser, int[][] board, boolean[][] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(loser);
        visited[winner][loser] = true;
        while(!queue.isEmpty()) {
            int l = queue.poll();
            for(int i = 0; i < board.length; i++) {
                if(!visited[l][i] && board[l][i] == 1) {
                    queue.offer(i);
                    // 진 사람들 체크, 이긴 사람 체크
                    visited[l][i] = true;
                    visited[i][l] = true;
                    board[winner][i] = 1;
                    board[i][winner] = -1;
                };
            }
        }
    }
}