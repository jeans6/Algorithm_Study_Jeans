import java.util.*;

class Solution {
    List<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        // 양방향 그래프 만들기
        graph = new List[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < wires.length; i++) {
            graph[wires[i][0]-1].add(wires[i][1]-1);
            graph[wires[i][1]-1].add(wires[i][0]-1);
        }
        
        // 전력망 끊어서 개수 세기
        int answer = n;
        for(int i = 0; i < wires.length; i++) {
            int n1 = bfs(wires[i][0]-1, wires[i][1]-1, new boolean[n]);
            int n2 = bfs(wires[i][1]-1, wires[i][0]-1, new boolean[n]);
            answer = Math.min(answer, Math.abs(n1-n2));
        }
        
        return answer;
    }
    
    int bfs(int start, int end, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;
            for(int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if(next == end || visited[next]) continue;
                visited[next] = true;
                queue.offer(next);
            }
        }
        return cnt;
    }
}