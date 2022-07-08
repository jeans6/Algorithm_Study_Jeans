import java.util.*;

class Solution {
    static long answer;
    public long solution(int w, int h) {
        answer = (long)w * h;
        long y1 = 0;
        double y2 = 0.0;
        //정사각형이면 그냥 바로 계산
        if(w == h)
            return answer-w;
        
        //y = ax (a = 기울기(=h/w))로 보고
        //x=1일때의 y값과, x=2일때의 y값을 구한 후
        //그 사이에 있는 숫자들 구해서 카운트한 후 answer에서 빼주기
        for(long i = 1; i <= w; i++){
            y1 = (long)y2;
            y2 = (h*i/(double)w);
            long count = (long)(y2-y1);
            if(y2 % 1 != 0)
                count++;
            
            answer -= count;
        }
        
        return answer;
    }
}