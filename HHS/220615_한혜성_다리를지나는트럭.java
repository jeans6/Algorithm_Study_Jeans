package HHS;

import java.util.*;

class Solution {
    static ArrayList<Drive> driving;
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 총 걸린 시간
        int truck = 0;//완주한 트럭 개수
        driving = new ArrayList<>(); //현재 다리위에 있는 트럭의 무게와 입장 시간
        
        int sum = 0;
        
        while(true){
            //다 완주했으면 나가
            if(truck == truck_weights.length)
                break;
            
            // 아직 운행중인 애들이 있을 때 가장 먼저 들어간 값의 시간 계산 시 다리 다 건넜으면 
            // 다리 위 무게 빼고 트럭 개수 올려
            if(driving.size() <= truck_weights.length 
            && driving.size()-truck > 0 
            && (answer-driving.get(truck).time) == bridge_length){   
                
                sum -= driving.get(truck).weight;
                truck++;
                
            }
            
            // 아직 대기중인 애들이 있고, 다리 위로 더 올릴 수 있을 때
            if(driving.size() < truck_weights.length 
               && bridge_length > driving.size()-truck){
               
                // 올리려는 애와의 합이 weight 이하이면 총 무게에 해당 무게 더하고 driving리스트에 추가해
                if(sum + truck_weights[driving.size()] <= weight){
                    sum += truck_weights[driving.size()];
                    driving.add(new Drive(truck_weights[driving.size()], answer));
                    
                }
            }
            // 시간은 흘러
            answer++;
        } 
        
        return answer;
    }
}
class Drive{
    int weight;
    int time;
    public Drive(int weight, int time){
        this.weight = weight;
        this.time = time;
    }
}