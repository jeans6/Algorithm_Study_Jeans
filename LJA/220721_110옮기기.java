class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for(int t = 0; t < s.length; t++) {
            StringBuilder sb = new StringBuilder(s[t]);
            // 문자열에 110이 있으면 제거하고, str110에 저장
            StringBuilder str110 = new StringBuilder();
            for(int i = 0; i < sb.length()-2; i++) {
                if(sb.substring(i, i+3).equals("110")) {
                    str110.append("110");
                    sb.delete(i, i+3);
                    // 이 부분.. 반복문 i++ 때문에 다음 반복때 0부터 시작하려면 -1로 해줬어야하는데 약간 생각없이 0으로 쓰다가 한참 헤맸다..
                    i = (i-5 < -1? -1 : i-5);
                }
            }
            // 문자열을 뒤에서 부터 탐색해 0이 나오는 곳에 110을 붙여줌
            int zeroIdx;
            for(zeroIdx = sb.length()-1; zeroIdx >= 0; zeroIdx--) {
                if(sb.charAt(zeroIdx) == '0') break;
            }
            
            sb.insert(zeroIdx+1, str110);
            answer[t] = sb.toString();
        }
        return answer;
    }
}

// https://mapadubak.tistory.com/128