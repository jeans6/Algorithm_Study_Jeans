package HHS;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length();

        for(int i = 0; i < name.length(); i++){
            int count = name.charAt(i)-'A';
            
            if(count <= 13){
                answer += count;
            }else answer += 26 - count;
            
            //현재 인덱스에서 출발해서 바로 다음이 A라면 연속하는 'A'의 개수 파악
            int place = i+1;
            while(place < name.length() && name.charAt(place) == 'A'){
                place++;
            }
            
            //연속되는 A들에게 가능 최적 방법<구글링 참고>
            //앞으로 가는 방법
            move = Math.min(move, (i*2) + name.length()-place);
            //뒤로 돌아 가는 방법
            move = Math.min(move, (name.length()-place) * 2 + i);
        }
        return answer+move;
    }
}