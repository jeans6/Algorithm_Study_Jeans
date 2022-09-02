import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            long num = numbers[i];
            if(num % 4 == 3){
                String bin = Long.toBinaryString(num);
                int idx = -1;
                for(int j = 0; j < bin.length()-1; j++){
                    if(bin.charAt(j) == '0' && bin.charAt(j+1) == '1'){
                        idx = j;
                    }
                }
                if(idx != -1){
                    String ans = bin.substring(0, idx)+"10"+bin.substring(idx+2, bin.length());
                    answer[i] = Long.parseLong(ans, 2);
                }
                else{
                    String temp = "10";
                    for(int j = 1; j < bin.length(); j++)
                        temp += bin.charAt(j);
                    answer[i] = Long.parseLong(temp, 2);
                }
            }    
            else
                answer[i] = num + 1;
        }
        
        return answer;
    }
}