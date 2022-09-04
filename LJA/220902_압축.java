import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<String> list = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();
        // 사전 초기화
        for(int i = 'A'; i <= 'Z'; i++) list.add(Character.toString(i));
        
        // msg를 돌면서 없는 new문자열인 경우 사전에 넣기 + new문자열 이전에 있는 문자열 색인 answerList에 넣기
        for(int i = 0; i < msg.length(); i++) {
            for(int j = i+1; j <= msg.length(); j++) {
                String str = msg.substring(i, j);
                if(!list.contains(str)) {
                    list.add(str);
                    answerList.add(list.indexOf(msg.substring(i, j-1))+1);
                    i = j-2;
                    break;
                } else if((i+msg.substring(i, j).length()) == msg.length()) {
                    answerList.add(list.indexOf(msg.substring(i,j))+1);
                    i = msg.length();
                }
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) answer[i] = answerList.get(i);
        return answer;
    }
}