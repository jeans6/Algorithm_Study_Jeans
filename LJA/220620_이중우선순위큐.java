import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 최소힙, 최대힙 만들기
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) {
            String op[] = operations[i].split(" ");
            if(op[0].equals("I")) {
                // 힙 각각에 숫자 insert
                minHeap.offer(Integer.parseInt(op[1]));
                maxHeap.offer(Integer.parseInt(op[1]));
            } else if(op[0].equals("D") && !minHeap.isEmpty()) {
                // 힙이 비어있지 않으면 delete연산
                int n = Integer.parseInt(op[1]);
                if(n < 0) {
                    maxHeap.remove(minHeap.poll());
                } else {
                    minHeap.remove(maxHeap.poll());
                }
            }
        }
        
        if(minHeap.isEmpty()) return new int[]{0, 0};
        return new int[]{maxHeap.peek(), minHeap.peek()};
    }
}