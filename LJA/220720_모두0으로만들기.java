import java.util.*;

class Solution {
    long answer;
    int[] A;
    List<List<Integer>> graph;
    long[] Ans;
    
    public long solution(int[] a, int[][] edges) {
        answer = 0;
        A = a;
        graph = new ArrayList<>();
        Ans = new long[a.length];
        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            graph.add(new ArrayList<>()); // 양방향 그래프 만들기
            Ans[i] = a[i]; // 가중치의 합을 저장할 배열
            sum += a[i];
        }
        // 가중치가 0이 안되는 경우 끝
        if(sum != 0) return -1;
        
        // 양방향 그래프 만들기    
        for(int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        // dfs
        dfs(0, new boolean[A.length]);
        
        return answer;
    }
    
    long dfs(int idx, boolean[] visited) {
        visited[idx] = true;
        for(int i = 0; i < graph.get(idx).size(); i++) {
            int nextIdx = graph.get(idx).get(i);
            if(visited[nextIdx]) continue;
            Ans[idx] += dfs(nextIdx, visited); // 자식값을 부모에 더해서 부모 가중치 업데이트해줌
        // System.out.println(Arrays.toString(Ans));
        }
        answer += Math.abs(Ans[idx]);
        return Ans[idx];
    }
}