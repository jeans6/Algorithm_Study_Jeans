import java.util.*;
class Solution {
    int[][] D;
    int N, K, answer;
    
    public int solution(int k, int[][] dungeons) {
        D = dungeons;
        K = k;
        N = D.length;
        answer = 0;
        perm(0, new boolean[N], new int[N]);
        return answer;
    }
    
    // 순열
    void perm(int cnt, boolean[] visited, int[] arr) {
        if(cnt == N) {
            int p = K;
            int max = 0;
            for(int i = 0; i < N; i++) {
                if(p >= D[arr[i]][0]) {
                    p -= D[arr[i]][1];
                    max++;
                }
            }
            answer = Math.max(answer, max);
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[cnt] = i;
            perm(cnt+1, visited, arr);
            visited[i] = false;
        }
    }
}