import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        // 양방향 그래프 만들기, 빈 곳은 MAX 값으로 채움  
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i==j) continue;
                arr[i][j] = 500001;
            }
        }
        
        for(int i = 0; i < road.length; i++) {
            if(arr[road[i][0]-1][road[i][1]-1] < road[i][2]) continue;
            arr[road[i][0]-1][road[i][1]-1] = road[i][2];
            arr[road[i][1]-1][road[i][0]-1] = road[i][2];
        }
        
        for(int k = 0; k < N; k++) { // 경유지 
            for(int i = 0; i < N; i++) { // 시작
                for(int j = 0; j < N; j++) { // 도착
                    arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < N; i++) if(arr[0][i] <= K) answer++;
        return answer;
    }
}