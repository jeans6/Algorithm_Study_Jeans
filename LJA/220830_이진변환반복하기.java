class Solution {
    int[] answer;
    
    public int[] solution(String s) {
        answer = new int[2];
        while(true) {
            if(s.equals("1")) break;
            s = Integer.toBinaryString(toBinary(s));
        }
        return answer;
    }
    
    int toBinary(String s) {
        answer[0]++;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) if(s.charAt(i) == '1') sb.append("1");
        answer[1] += s.length()-sb.length();
        return sb.length();
    }
}