import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        //A 정렬해놓고
        //큰 값부터 비교, 
        //B가 더 크면 그거 쓰고
        //같거나 더 작으면 가장 작은 애 줘버리기

        Arrays.sort(A);
        Arrays.sort(B);
        
        int end = B.length-1;
        for(int i = B.length-1; i >= 0; i--){
            if(A[i] < B[end]){
                answer++;
                end--;
            }
        }
        
        return answer;
    }
}