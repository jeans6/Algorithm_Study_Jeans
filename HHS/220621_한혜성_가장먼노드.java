import java.util.*;

class Solution {
    static int answer;
    static int maxCount;
    static boolean [] visited;
    static boolean [][] map;
    
    public int solution(int n, int[][] edge) {
    
        visited = new boolean[n+1];
        
        // 양방향 노드 여부 담을 곳
        map = new boolean[n+1][n+1];
        
        visited[0] = true;
        
        //양방향 처리
        for(int i = 0; i < edge.length; i++){
            int s = edge[i][0];
            int e = edge[i][1];
            map[s][e] = true;
            map[e][s] = true;
        }
        
        bfs();
        
        return answer;
    }
    private static void bfs(){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(1, 0));
        
        while(!que.isEmpty()){
            Node node = que.poll();
            int num = node.num;
            int count = node.count;
            
            //방문했던 넘버면 나가
            if(visited[num]) continue;
            
            //간선 개수가 현재 맥스값과 같다면 answer 올리기
            if(maxCount == count)
                answer++;
            
            //맥스값보다 더 큰 카운트면 answer = 1 로 초기화시키고 max 값 바꿔주기
            else if(maxCount < count){
                answer = 1;
                maxCount = count;
            }
            
            
            visited[num] = true;
            for(int i = 1; i < visited.length; i++){
                if(map[i][num]){
                    que.add(new Node(i, count+1));
                }
            }
            
            
        }
        
    }
}
class Node{
    int num;
    int count;
    public Node(int num, int count){
        this.num = num;
        this.count = count;
    }
}