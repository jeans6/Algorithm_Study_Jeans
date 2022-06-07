package HHS;
import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String answer;
        StringBuilder sb = new StringBuilder();
        
        String [] nums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            nums[i] = String.valueOf(numbers[i]);
        }
        //compareTo 람다식
        Arrays.sort(nums, (o1,o2) -> (o2+o1).compareTo(o1+o2));
        
        for(String num : nums){
            sb.append(num);
        }
            
        answer = sb.toString();
        
        //죄다 0인 경우 0으로 출력
        if(nums[0].equals("0"))
            answer = "0";
        
        return answer;
    }

}