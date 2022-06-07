package HHS;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        //답이 citations안에 없을 수 있음
        int a = citations[citations.length-1];
        while(a >= 0){
            int count = 0;
            for(int i = citations.length-1; i >= 0; i--){
                if(a <= citations[i])
                    count++;
            }
            if(count >= a){
                answer = a;
                break;
            }
            a--;
        }
        return answer;
    }
}