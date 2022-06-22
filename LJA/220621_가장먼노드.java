import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        visited = new boolean[n];
        // 노드 개수 만큼 초기화
        for(int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }
        // 양방향 그래프로 만들기
        for(int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]-1).add(edge[i][1]-1);
            graph.get(edge[i][1]-1).add(edge[i][0]-1);
        }
        int answer = bfs();
        return answer;
    }
    
    public int bfs() {
        // 0번 시작
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        int cnt = 0;
        while(true) {
            // 현재 노드와 인접한 노드들을 저장할 리스트
            Queue<Integer> temp = new LinkedList<>();
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                // 현재 노드와 인접한 노드 방문여부 확인해서
                // 방문X이면 temp와 visited에 방문 체크
                for(int adj : graph.get(cur)) {
                    if(visited[adj]) continue;
                    temp.add(adj);
                    visited[adj] = true;
                }
            }
            // 더 이상 인접한 노드가 없는 경우(제일 멀리 간 경우 끝)
            if(temp.isEmpty()) break;
            // 다음에 방문할 노드(인접노드) 넣어줌
            queue.addAll(temp);
            // 같은 거리에 있는 노드들의 개수
            cnt = temp.size();
        }
        return cnt;
    }
}
// 참고 : https://velog.io/@hammii/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B0%80%EC%9E%A5-%EB%A8%BC-%EB%85%B8%EB%93%9C-java