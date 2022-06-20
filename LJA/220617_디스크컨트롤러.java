import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        // 큐에 작업시간이 짧은 순으로 정렬해서 들어감
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // 작업이 빨리 시작되는 순으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        int idx=0, time=jobs[0][0];
        while(idx < jobs.length || !q.isEmpty()){
            // 현재 진행된 시간과 겹치거나 이전에 수행됐어야 할 작업들을 큐에 넣어줌
            while(idx<jobs.length && jobs[idx][0] <= time){
                q.offer(jobs[idx++]);
            }
            // 테케19번에 걸림, 돌다가 큐가 비는 경우를 처리(시간이 안겹칠때)
            if(q.isEmpty()){
                time = jobs[idx][0];
                q.offer(jobs[idx++]);
            }
            // 작업 하나 처리!
            int[] work = q.poll();
            time += work[1];
            answer += time-work[0];
        }
        return answer/jobs.length;
    }
}
// 참고 : https://jgeun97.tistory.com/m/134