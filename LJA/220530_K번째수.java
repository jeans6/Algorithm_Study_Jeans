import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        // commands의 수만큼 반복
        for(int n = 0; n < commands.length; n++) {
            // 배열의 index가 0부터 시작하는 걸 고려해 변수 초기화
            int i = commands[n][0]-1;
            int j = commands[n][1]-1;
            int k = commands[n][2]-1;
            // i부터 j까지 자른 수들을 담기위한 배열
            int[] temp = new int[j-i+1];
            for(int m = 0; m < j-i+1; m++) {
                temp[m] = array[i+m];
            }
            // 정렬 후 answer에 값을 넣어줌
            Arrays.sort(temp);
            answer[n] = temp[k];
        }
        return answer;
    }
}