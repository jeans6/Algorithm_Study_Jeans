class Solution {
    static int[] arr;
    static int answer;
    
    public int solution(int n) {
        answer = 0;
        arr = new int[n]; // 퀸이 위치한 열을 담을 배열(행은 arr의 index값으로 생각)
        nQueen(0, n);
        return answer;
    }
    
    public static void nQueen(int depth, int n) {
        if(depth == n) { // 퀸을 다 놓으면 끝
            answer++;
            return;
        }
        for(int i = 0; i < n; i++) {
            arr[depth] = i;
            if(isPossible(depth, n)) {
                nQueen(depth+1, n);
            }
        }
    }
    
    public static boolean isPossible(int c, int n) {
        // 같은 행에 위치할 경우와 대각선에 위치해있는지 체크
        for(int i = 0; i < c; i++) {
            if(arr[c] == arr[i]) {
                return false;
            } else if(Math.abs(c-i) == Math.abs(arr[c]-arr[i])) { // 열의 차와 행의 차가 같을 경우 대각선에 위치한다고 한다
                return false;
            }
        }
        return true;
    }
}

// 참고 https://st-lab.tistory.com/118