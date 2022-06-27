import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int[][] jobs) {
        //매 초마다 그 시간까지 요청이 되어있는 애들 PriorityQueue에 넣기
        //pq는 일 처리 가장 빨리 끝나는 애들순으로 정렬
        //처리하는 애가 없는 경우 pq 첫번째 애 뽑아서 처리시키기
        //모든 애들 다 처리했으면 평균 시간 계산
        int count = 0;
        
        LinkedList<Disk> progress = new LinkedList<>();//작업중인 애 담을 곳
        
        PriorityQueue<Disk> pq = new PriorityQueue<>();//작업 후보군 담을 곳
        
        Arrays.sort(jobs, Comparator.comparingInt(o1-> o1[0]));
        int max = jobs[jobs.length-1][0];
        int time = 0;
        int sum = 0;
        
        while(count < jobs.length){

            //해당 시간부터 요청할 수 있는 애들 큐에 넣기
            if(time <= max){
                int size = pq.size();
                for(int i = count+size; i < jobs.length; i++){
                    if(jobs[i][0] == time){
                        pq.add(new Disk(jobs[i][0], jobs[i][1], 0));
                    }
                }    
            }
            //초기 설정
            if(progress.isEmpty() && !pq.isEmpty()){
                Disk d = pq.poll();
                progress.add(new Disk(d.startAsk, d.contTime, time));                
            }
            
            //작업 끝난 경우 다른 작업 또 시작하기
            if(!progress.isEmpty()){
                Disk p = progress.get(progress.size()-1);
                if(time == p.contTime + p.startTime){
                    count++;
                    sum += time - p.startAsk;
                    progress.poll();
                    if(!pq.isEmpty()){
                        Disk d = pq.poll();
                        progress.add(new Disk(d.startAsk, d.contTime, time));
                    }
                }
            }
            
            time++;
            
            
        }
        return sum/count;
    }
}
class Disk implements Comparable<Disk>{
    int startAsk;
    int contTime;
    int startTime;
    
    public Disk(int startAsk, int contTime, int startTime){
        this.startAsk = startAsk;
        this.contTime = contTime;
        this.startTime = startTime;
    }
    
    @Override
    public int compareTo(Disk o){
        if(this.contTime < o.contTime)
            return -1;
        else if(this.contTime == o.contTime){
            return this.startAsk - o.startAsk;
        }
        return 1;
    }
        
}