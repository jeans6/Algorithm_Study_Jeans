import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        //sort한 후에 앞과 뒤가 같이 탈 수 있으면 카운트 올리기
        //뒤가 안되면 걔만 카운트 하고 넘어가
        
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length-1;
        
        while(start <= end){
            
            if(people[start] + people[end] <= limit){
                answer++;
                start++;
                end--;
            }else{
                answer++;
                end--;
            }
        }
        return answer;
    }
}