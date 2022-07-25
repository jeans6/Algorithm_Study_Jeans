import java.util.*;

class Solution {
    int N, MinCnt;
    int[] Weak;
    int[] Dist;
    
    public int solution(int n, int[] weak, int[] dist) {
        Arrays.sort(dist);
        N = n;
        Weak = weak;
        Dist = dist;
        MinCnt = 9;
        
        for(int i = 0; i < Weak.length; i++) {
            solve(1, i, 0); // +1명을 사용해서 i번째를 방문하는데 비트연산자에 따라 0(아직 방문X)
        }
        
        if(MinCnt == 9) return -1;
        return MinCnt;
    }
    
    void solve(int cnt, int pos, int visited) {
        if(cnt > Dist.length) return;
        if(cnt > MinCnt) return;
        
        for(int i = 0; i < Weak.length; i++) {
            int nextPos = (pos + i) % Weak.length; // 취약점 방문
            int diff = Weak[nextPos] - Weak[pos]; // 다음 취약점까지의 거리
            
            // 한바퀴 돌았을 때
            if(nextPos < pos) diff += N;
            
            // 취약점 방문할 수 있는지 확인(가장 긴 거리부터 사용)
            if(diff > Dist[Dist.length-cnt]) break;
            visited |= 1 << nextPos;
        }
        
        if(visited == (1 << Weak.length) - 1) {
            MinCnt = cnt; // 위에서 가지치기했기 때문에 여기까지 왔다는건 최소값이라는 것
            return;
        }
        
        for(int i = 0; i < Weak.length; i++) {
            if((visited & (1 << i)) != 0) continue;
            solve(cnt+1, i, visited);
        }
    }
}

// 참고 : https://www.youtube.com/watch?v=LtPYdZbJlzk