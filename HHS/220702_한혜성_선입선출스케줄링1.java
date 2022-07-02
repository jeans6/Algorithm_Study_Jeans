//효율성 테스트 통과 X
//정확성 테스트 통과 O
import java.util.*;

class Solution {
    
    public int solution(int n, int[] cores) {
        int answer = 0;
        int count = cores.length;
        
        //일찍 끝나는 순으로 정렬, 그 후에는 빠른 인덱스순으로 정렬
        PriorityQueue<Core> core = new PriorityQueue<>((o1,o2)->{
            if(o1.end_time == o2.end_time)
                return o1.core_id - o2.core_id;
            return o1.end_time - o2.end_time;
        });
        
        //처리할 수 있는 코어가 n보다 더 많으면 그냥 n바로 출력
        if(cores.length >= n)
            return n;
        
        //코어에 일단 초기값 다 넣어주기 (끝나는 시간, 코어 번호-1)
        for(int i = 0; i < cores.length; i++){
            core.add(new Core(cores[i], i));
        }
        
        while(count <= n){
            //하나 뽑고 다음꺼 넣어주고 카운트 올려
            Core c = core.poll();    
            core.add(new Core(c.end_time + cores[c.core_id], c.core_id));
            count++;
            
            //count == n이면 바로 해당 코어 번호 출력
            if(count == n)
                return c.core_id+1;
            
        }
        
        
        return answer;
    }
}
class Core{
    int end_time;
    int core_id;
    
    public Core(int end_time, int core_id){
        this.end_time = end_time;
        this.core_id = core_id;
    }
    
}