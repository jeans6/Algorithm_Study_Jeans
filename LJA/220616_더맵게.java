import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 우선순위큐(최소힙)을 사용하면 항상 첫번째가 최솟값
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville) queue.offer(s);
        
        while(!queue.isEmpty()) {
            int s1 = queue.poll();
            // 최소값이 K를 넘으면 섞는걸 멈춤
            if(s1 >= K) break;
            // 섞을 음식이 없으면 -1
            if(queue.isEmpty()) return -1;
            int s2 = queue.poll();
            answer++;
            queue.offer(s1+(s2*2));
        }
        if(!queue.isEmpty() && queue.poll() < K) answer = -1;
        return answer;
    }
}