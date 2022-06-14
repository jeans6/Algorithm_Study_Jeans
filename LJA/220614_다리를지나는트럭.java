import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, total = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];
            while(true) {
                // 길이 초과시
                if(queue.size() >= bridge_length) {
                    total -= queue.poll();
                } else { // 길이 초과 안했을 때
                    // 무게 초과시
                    if(total + truck > weight) {
                        // 처음에 queue에 있는 값을 빼줘야한다고 생각했는데
                        // 0을 넣어서 밀어내는게 맞다...!
                        queue.offer(0);
                        answer++;
                    } else {
                        queue.offer(truck);
                        total += truck;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer+bridge_length;
    }
}