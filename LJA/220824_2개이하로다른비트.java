import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            StringBuilder binary = new StringBuilder(Long.toBinaryString(numbers[i]));
            int zeroIdx = binary.lastIndexOf("0");
            // 비트에 0이 있는 경우 11 -> 101 이런식으로 바꾸는게 제일 작은 수
            if(zeroIdx == -1) {
                binary.setCharAt(0, '0');
                binary.insert(0, '1');
            } else {
                // 비트에 0이 없는 경우 제일오른쪽부터 0을찾아 0 -> 1로 바꾸고 그 다음 비트 1로 바꿔줌
                binary.setCharAt(zeroIdx, '1');
                if(zeroIdx+1 < binary.length()) binary.setCharAt(zeroIdx+1, '0');
            }
            answer[i] = Long.parseLong(binary.toString(), 2);
        }
        return answer;
    }
}