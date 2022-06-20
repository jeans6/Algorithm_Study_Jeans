import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length()-k;
        int maxIdx = 0;
        int max = 0;
        
        for(int n = 1; n <= len; n++) {
            for(int i = maxIdx; i < number.length()-(len-n); i++) {
                if(max < number.charAt(i)-'0') {
                    maxIdx = i;
                    max = number.charAt(i)-'0';
                }
                if(max == 9) break;
            }
            answer.append(max);
            max = 0;
            maxIdx++;
        }
        return answer.toString();
    }
}