import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        //큐 비어있을 경우 0 출력하게 초기화
        int Max = 0;
        int Min = 0;
        
        //우선순위큐를 이용하여 queue 적용
        PriorityQueue<Integer> que = new PriorityQueue<>();
        StringTokenizer token = null;
        for(int i = 0; i < operations.length; i++){
            
            token = new StringTokenizer(operations[i]);
            String ID = token.nextToken();
            int num = Integer.parseInt(token.nextToken());
            
            if(ID.equals("I")){
                que.add(num);
            }else if(ID.equals("D") && !que.isEmpty()){
                if(num == -1)
                    que.poll();
                
                else{
                    //큰 수를 빼야하는 경우 큐 하나 더 만들어서 마지막값 제외하고 다 옮기고
                    //다시 원래 우선순위큐에 넣어주기 -> 큰 값만 빠지게 됨  
                    Queue<Integer> newQue = new LinkedList<>();
                    int size = que.size()-1;
                    for(int j = 0; j < size; j++){
                        newQue.add(que.poll());
                    }
                    
                    que.clear();
                    for(int no : newQue){
                        que.add(no);
                    }
                }
                    
            }
        }
        //2개이상 들어있으면 큰 값, 작은 값 따로 구하기
        if(que.size() > 1){
            
            Min = que.poll();
            int size = que.size()-1;
            for(int i = 0; i < size; i++){
                que.poll();
            }
            Max = que.poll();

        }else if(que.size() == 1){ //값 하나만 들어있으면 둘 다 동일한 값 출력
            Min = que.poll();
            Max = Min;
            
        }
        answer[0] = Max;
        answer[1] = Min;
        
        return answer;
    }
}