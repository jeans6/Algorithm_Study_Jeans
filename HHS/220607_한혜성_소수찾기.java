package HHS;

import java.util.*;

class Solution {
    static HashSet<Integer> hs;
    static boolean [] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new boolean[numbers.length()];
        hs = new HashSet<>();
        String num = "";
        
        //순열로 num 만들어보고 소수인지 판별한 후 
        //소수이면 hs에 넣기
        perm(0, numbers, num);
        answer = hs.size();
        
        return answer;
    }
    private void perm(int cnt, String numbers, String num){
        if(cnt == numbers.length())
            return;
        
        for(int i = 0; i < numbers.length(); i++){
            //방문했으면 나가
            if(visited[i]) continue;
            
            visited[i] = true;
            //숫자 조합해보고 소수인지 판별
            String number = num + numbers.charAt(i);
            
            if(isPrime(number))
                hs.add(Integer.parseInt(number));
            
            perm(cnt+1, numbers, number);
            visited[i] = false;
            
        }
        
    }
    private boolean isPrime(String number){
        int num = Integer.parseInt(number);
        
        if(num == 0 || num == 1)
            return false;
        
        for(int i = 2; i < num; i++){
            if(num % i == 0)
                return false;
        }
        
        return true;
    }
}