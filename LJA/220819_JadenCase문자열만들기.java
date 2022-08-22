class Solution {
    public String solution(String s) {
        int toU = 'A'-'a'; // 소문자 대문자로 바꾸기 위한 변수
        s = s.toLowerCase(); // 문자열 모두 소문자로 변경
        StringBuilder answer = new StringBuilder();
        StringBuilder word = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                // 공백이 연속되어있는 경우와 공백이면서 문자가 있는 경우를 고려
                if(word.length() > 0 && word.charAt(0) >= 'a' && word.charAt(0) <= 'z') {
                    word.setCharAt(0, (char)(word.charAt(0)+toU));
                }
                answer.append(word+" ");
                word.setLength(0);
            } else { // 공백을 만날때까지 char 저장
                word.append(s.charAt(i));
            }
        }
        
        // 마지막 문자에 공백이 없는 경우 처리되지 않은 단어 처리
        if(word.length() > 0) {
            if(word.charAt(0) >= 'a' && word.charAt(0) <= 'z') {
                word.setCharAt(0, (char)(word.charAt(0)+toU));
            }
            answer.append(word);
        }
        return answer.toString();
    }
}