class Solution {
    public int solution(String s) {
        int answer = s.length();
        // i개씩 자르기
        for(int i = 1; i <= s.length()/2; i++) {
            int len = s.length();
            for(int j = 0; j <= s.length()-i; j=j+i) {
                // 압축할 문자열
                String str = s.substring(j, j+i);
                // 중복되는 문자열이 몇개있는지 확인할 변수
                int cnt = 0;
                while(j+i <= s.length()-i) {
                    String next = s.substring(j+i, j+i+i);
                    if(str.equals(next)) {
                        cnt++;
                        j=j+i;
                    } else {
                        break;
                    }
                }
                if(cnt > 0) len -= (i*cnt-(cnt+1+"").length());
            }
            answer = Math.min(answer, len);
        }
        return answer;
    }
}