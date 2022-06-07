import java.util.*;

class Solution {
    
    public static Set<Integer> set;
    boolean[] visited = null;
    
    public int solution(String numbers) {
        char[] arr = numbers.toCharArray();
        set = new HashSet<>();
        
        visited = new boolean[arr.length];
        perm(0, arr.length, arr, "");
        return set.size();
    }
    
    // 순열을 사용해서 문제 풀이
    public void perm(int cnt, int end, char[] arr, String str) {
        // 끝나는 조건
        if(cnt > arr.length) return;
        
        // 모든 경우에 대해 소수인지 체크 후 set에 넣어줌
        if(str != "") {
            int num = Integer.parseInt(str);
            if(isPrime(num)) set.add(num);
        }
        
        for(int i = 0; i < end; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            perm(cnt+1, end, arr, str+arr[i]);
            visited[i] = false;
        }
    }
    
    // 소수인지 판별하는 함수
    public boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}