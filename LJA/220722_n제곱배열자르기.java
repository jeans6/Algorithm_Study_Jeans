import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {        
        int[] answer = new int[(int)(right-left+1)];
        
        int cnt = 0;
        int rs = (int)(left/n);
        int re = (int)(right/n);
        int cs = (int)(left%n);
        int ce = (int)(right%n);
        while(cnt < answer.length) {
            answer[cnt++] = (rs>cs ? rs+1 : cs+1);
            cs++;
            if(cs >= n) {
                cs = 0;
                rs++;
            }
            if(rs >= re && cs > ce) break;
            if(rs > re) break;
        }
        return answer;
    }
}