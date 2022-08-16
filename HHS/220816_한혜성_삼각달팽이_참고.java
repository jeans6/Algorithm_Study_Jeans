package HHS;

import java.util.*;
class Solution {
    static int [][] map;
    public int[] solution(int n) {
        
        map = new int[n][n];
        
        int count = 0;
        int r = -1;
        int c = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i % 3 == 0)
                    r++;
                else if(i % 3 == 1)
                    c++;
                else if(i % 3 == 2){
                    r--;
                    c--;
                }
                map[r][c] = ++count;
            }
        }
        int[] answer = new int[count];

        int a = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                if(map[i][j] != 0)
                    answer[a++] = map[i][j];
        }
        return answer;
    }
}