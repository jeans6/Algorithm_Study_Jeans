import java.util.*;

class Solution {
    public int[][] solution(int n) {
        List<int[]> moveList = new ArrayList<>();
        // n번 원판을 1->3으로 옮김
        hanoi(n, 1, 2, 3, moveList); // (n번 원판, 첫번째, 두번째, 세번째 기둥)
        int[][] answer = new int[moveList.size()][2];
        for(int i = 0; i < moveList.size(); i++) {
            answer[i][0] = moveList.get(i)[0];
            answer[i][1] = moveList.get(i)[1];
        }
        return answer;
    }
    
    private void hanoi(int n, int start, int mid, int end, List<int[]> moveList) {
        if(n==0) return;
        hanoi(n-1, start, end, mid, moveList);
        moveList.add(new int[]{start, end});
        hanoi(n-1, mid, start, end, moveList);
    }
}