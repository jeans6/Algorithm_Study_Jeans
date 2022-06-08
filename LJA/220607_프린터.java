import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int length = priorities.length;
        Queue<int[]> queue = new LinkedList<>();
        // 큐에 현 위치, 중요도 넣어줌
        for(int i = 0; i < length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }
        // 중요도 순으로 정렬
        Arrays.sort(priorities);
        for(int i = 0; i < length; i++) {
            int max = priorities[length-1-i];
            while(!queue.isEmpty()) {
                int[] arr = queue.poll();
                // 현재 대기열 중 중요도가 가장 높으면 꺼냄, 내가 요청한 문서일 경우 return
                if(max == arr[1]) {
                    answer++;
                    if(arr[0] == location) return answer;
                    break;
                }
                // 중요도가 높지 않아 다시 que로 들어감
                queue.offer(arr);
            }
        }
        return answer;
    }
}