package HHS;

import java.util.*;

class Solution {
    static int answer;
    static Queue<Print> que;
    public int solution(int[] priorities, int location) {
        que = new LinkedList<>();

        //큐에 일단 다 넣기
        
        for(int i = 0; i < priorities.length; i++){
            que.add(new Print(i, priorities[i]));
        }
        Arrays.sort(priorities);
        
        answer = bfs(priorities, location);
        
        return answer;
    }
    private int bfs(int [] pr, int loc){
        //정렬되어있는 배열을 돌면서 큐에서 뽑아낸 값이 최대값일 경우 뽑기
        //최대값이 아니면 다시 큐에 넣기
        for(int i = pr.length-1; i >= 0; i--){
            
            while(!que.isEmpty()){
                Print p = que.poll();
            
                int index = p.index;
                int value = p.value;

                if(value == pr[i]){
                    answer++;
                    if(index == loc)
                        return answer;
                    break;
                }
                que.add(new Print(index, value));
            }
        }
        return answer;

    }
        
}
class Print{
    int index;
    int value;

    public Print(int index, int value){
        super();
        this.index = index;
        this.value = value;
    }
}
