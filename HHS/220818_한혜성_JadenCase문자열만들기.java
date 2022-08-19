class Solution {
    public String solution(String s) {
        String answer = "";
        //숫자를 대문자 처리해도 상관없음
        //공백을 기준으로 첫 글자만 대문자로 바꿔주기
        //나머지는 다 소문자 처리
        for(int i = 0; i < s.length(); i++){
            if(i == 0 || (s.charAt(i-1) == ' ' && s.charAt(i) != ' ')){
                    answer += Character.toUpperCase(s.charAt(i));
            }else
                answer += Character.toLowerCase(s.charAt(i));
        }
        
        return answer;
    }
}