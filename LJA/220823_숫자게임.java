import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int N = A.length;
        int answer = 0, bIdx = 0, aIdx = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        while(aIdx < N && bIdx < N) {
            if(B[bIdx] > A[aIdx]) {
                answer++;
                aIdx++;
            }
            bIdx++;
        }
        
        return answer;
    }
}