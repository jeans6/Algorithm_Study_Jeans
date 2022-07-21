import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        // 누적해서 더해가는 방식
        for(int i = 1; i < triangle.length; i++) {
            int c = triangle[i].length;
            for(int j = 0; j < c; j++) {
                if(j-1 < 0) { // 전 행의 좌측열이 없는 경우
                    triangle[i][j] += triangle[i-1][j];
                } else if(j+1 >= c) { // 전 행의 우측열이 없는 경우
                    triangle[i][j] += triangle[i-1][j-1];
                } else { // 전 행에 비교해야 할 값이 2개이기 때문에 max로 값 정해줌
                    triangle[i][j] = triangle[i][j]+Math.max(triangle[i-1][j], triangle[i-1][j-1]);
                }
            }
        }
        // 마지막 행 중 가장 큰 값이 제일 큰 합
        int max = -1;
        int lastRow = triangle.length-1;
        for(int j = 0; j < triangle[lastRow].length; j++) {
            max = Math.max(max, triangle[lastRow][j]);
        }
        return max;
    }
}