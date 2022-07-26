import java.util.*;

class Solution {
    
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int len = triangle.length;
        
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i+1; j++){
                if(j == 0){
                    triangle[i][j] += triangle[i-1][0];
                }else if(j == i)
                    triangle[i][j] += triangle[i-1][i-1];
                else{
                    triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
                }
            }
        }
        
        for(int i = 0; i < len; i++){
            answer = Math.max(answer, triangle[len-1][i]);
        }
        
        return answer;
    }
}
