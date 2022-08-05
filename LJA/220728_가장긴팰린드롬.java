class Solution {
    String S;
    public int solution(String s) {
        int answer = 1;
        S = s;
        int len = S.length();
        for(int i = 0; i < len; i++) { // 시작 인덱스
            for(int j = len-1; j > i; j--) { // 끝 인덱스
                if(j-i+1 < answer) break;
                if(isPalindrome(i, j)) {
                    answer = Math.max(answer, (j-i+1));
                }
            }
        }
        return answer;
    }
    
    boolean isPalindrome(int start, int end) {
        for(int i = start, j = 0; i <= end; i++, j++) {
            if(S.charAt(i) != S.charAt(end-j)) return false;
        }
        return true;
    }
}