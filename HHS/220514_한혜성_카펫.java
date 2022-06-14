package HHS;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        //각 길이 x, y 일 때, x+y = (brown/2)+2,  xy = brown+yellow
        
        int sum = (brown/2)+2;
        
        for(int i = 1; i < sum; i++){
            int x = i;
            int y = sum-x;
            if(x*y == brown+yellow){
                answer[1] = x;
                answer[0] = y;
                break;
            }
        }
        
        return answer;
    }
}