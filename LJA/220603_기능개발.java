import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        // 작업을 끝나는 날짜 계산해서 queue에 넣어줌
        for(int i = 0; i < progresses.length; i++) {
            queue.offer((int)Math.ceil((double)(100 - progresses[i])/speeds[i]));
        }

        List<Integer> list = new ArrayList<>();
        // 비교를 위해 첫번째 데이터 꺼내고 시작
        int prev = queue.poll();
        int cnt = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            // 앞의 데이터가 현재 데이터보다 작으면 같이 배포할 수 없음
            if(prev < cur) {
                list.add(cnt);
                cnt = 1;
                prev = cur;
            } else {
                // 앞의 데이터가 현재 데이터보다 크거나 같으면 같이 배포할 수 있음
                cnt++;
            }
        }
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) answer[i] = list.get(i);
        return answer;
    }
}