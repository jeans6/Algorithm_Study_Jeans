class Solution {
    static int[][] matrix;
    public int[] solution(int rows, int columns, int[][] queries) {
        matrix = new int[rows][columns];
        int cnt = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = ++cnt;
            }
        }
        
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            answer[i] = rotate(rows, columns, queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
        }
        return answer;
    }
    
    public static int rotate(int r, int c, int x1, int y1, int x2, int y2) {
        int min = matrix[x1][y1];
        // 윗줄 돌리기
        int next1 = matrix[x1][y2];
        for(int i = 0; i < y2-y1; i++) {
            matrix[x1][y2-i] = matrix[x1][y2-i-1];
            min = Math.min(min, matrix[x1][y2-i-1]);
        }
        // 오른쪽줄 돌리기
        int next2 = matrix[x2][y2];
        for(int i = 0; i < x2-x1; i++) {
            matrix[x2-i][y2] = matrix[x2-i-1][y2];
            min = Math.min(min, matrix[x2-i-1][y2]);
        }
        matrix[x1+1][y2] = next1;
        min = Math.min(min, Math.min(next1, next2));
        
        // 아랫줄 돌리기
        next1 = matrix[x2][y1];
        for(int i = 0; i < y2-y1; i++) {
            matrix[x2][y1+i] = matrix[x2][y1+i+1];
            min = Math.min(min, matrix[x2][y1+i+1]);
        }
        matrix[x2][y2-1] = next2;
        
        // 왼쪽줄 돌리기
        for(int i = 1; i < x2-x1; i++) {
            matrix[x1+i-1][y1] = matrix[x1+i][y1];
            min = Math.min(min, matrix[x1+i][y1]);
        }
        matrix[x2-1][y1] = next1;
        min = Math.min(min, Math.min(next1, next2));
        return min;
    }

}