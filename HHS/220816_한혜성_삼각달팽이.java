package HHS;

import java.util.*;
class Solution {
    static int [] dr = {1,0,-1,0};//하 우 상 좌
    static int [] dc = {0,1,-1,-1};
    static int [][] map;
    static int N;
    static int len;
    public int[] solution(int n) {
        for(int i = 1; i <= n; i++)
            len += i;
        int[] answer = new int[len];
        N = n;
        map = new int[n][n];
        map[0][0] = 1;
        make(0, 0, 0, 2);
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[count++] = map[i][j];
            }
        }
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j <= i; j++){
        //         System.out.print(map[i][j] + " ");
        //     }System.out.println();
        // }
        return answer;
    }
    private static void make(int r, int c, int d, int num){
        
        for(int i = 0; i < 4; i++){
            int nr = r + dr[(d+i)%4];
            int nc = c + dc[(d+i)%4];
            
            if(!check(nr, nc)) continue;//범위 벗어나면 나가
            if(map[nr][nc] != 0) continue;//이미 방문했으면 나가
            
            map[nr][nc] = num;
            make(nr, nc, d+i, num+1);
            
            break;
            
        }
        
    }
    private static boolean check(int r, int c){
        return r >= 0 && r < N && c >= 0 && c <= r;
    }
    
}