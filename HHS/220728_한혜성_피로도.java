import java.util.*;

class Solution {
    
    static int answer;
    static int N;
    static int K;
    static int [][] map;
    public int solution(int k, int[][] dungeons) {

        N = dungeons.length;
        K = k;
        map = new int[N][2];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 2; j++){
                map[i][j] = dungeons[i][j];
            }
        }
        Permutation(0, new boolean [N], new int[N]);
        
        return answer;
    }
    public static void Permutation(int cnt, boolean [] visited, int []nums){
        if(cnt == N){
            //인덱스 순으로 돌려가면서 피로도 체크하는 함수로 가기
            answer = Math.max(go(0, nums), answer);
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            nums[cnt] = i;
            Permutation(cnt+1, visited, nums);
            visited[i] = false;
        }
        
    }
    
    public static int go(int count, int[] nums){
        int hp = K;
        for(int i = 0; i < N; i++){
            if(hp < map[nums[i]][0])
                continue;
            hp -= map[nums[i]][1];
            count++;
        }
        return count;
        
    }
    
}