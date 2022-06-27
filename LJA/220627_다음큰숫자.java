class Solution {
    public int solution(int n) {
        int cntN = countOne(Integer.toBinaryString(n));
        int answer = n+1;
        
        while(true) {
            if(cntN == countOne(Integer.toBinaryString(answer))) break;
            answer++;
        }
        return answer;
    }
    
    public static int countOne(String binary) {
        int cnt = 0;
        for(int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '1') cnt++;
        }
        return cnt;
    }
}