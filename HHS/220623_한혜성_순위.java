import java.util.*;

class Solution {

    static int [][] map;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
    
        map = new int [n][n];
        
        for(int i = 0; i < results.length; i++){
            int s = results[i][0] -1;
            int e = results[i][1] -1;

            map[s][e] = 1; //이기면 1
            map[e][s] = -1;//지면 -1
            
        }
        
        //map을 돌며 i가 j를 이긴 경우
        //j가 이긴 모든 k들에 대해 i > k 표시
        //그 반대도 동일
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1){
                    for(int k = 0; k < n; k++){
                        if(map[j][k] == 1)
                            map[i][k] = 1;
                    }
                }else if(map[i][j] == -1){
                    for(int k = 0; k < n; k++){
                        if(map[j][k] == -1)
                            map[i][k] = -1;
                    }
                }
            }
        }
        
        //모든 경우에 대해 한 번 더 돌려서 체크 누락된 부분 다시 체크
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1){
                    for(int k = 0; k < n; k++){
                        if(map[j][k] == 1)
                            map[i][k] = 1;
                    }
                }else if(map[i][j] == -1){
                    for(int k = 0; k < n; k++){
                        if(map[j][k] == -1)
                            map[i][k] = -1;
                    }
                }
            }
        }
        
        
        
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(map[i][j] != 0)
                    count++;
            }
            if(count == n-1)
                answer++;
        }
        
        return answer;
    }
}