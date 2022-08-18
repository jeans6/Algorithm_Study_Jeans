class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int r = -1, c = 0;
        int idx = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i%3 == 0) { // 밑으로
                    r++;
                } else if(i%3 == 1) { // 오른쪽으로
                    c++;
                } else if(i%3 == 2) { // 대각선위로
                    r--;
                    c--;
                }
                arr[r][c] = idx++;
            }
        }
        
        int[] answer = new int[(n*(n+1))/2];
        idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0) break;
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
}