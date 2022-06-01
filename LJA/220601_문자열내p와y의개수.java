class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt = 0;
        int yCnt = 0;
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == 'p' || cur == 'P') pCnt++;
            if(cur == 'y' || cur == 'Y') yCnt++;
        }
        answer = pCnt==yCnt?true:false;
        return answer;
    }
}