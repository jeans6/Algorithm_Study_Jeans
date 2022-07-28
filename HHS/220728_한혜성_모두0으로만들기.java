import java.util.*;
class Solution {
    
    static int N;
    static int [] e;
    static long [] arr;
    static ArrayList<Integer>[] edge;
    static boolean[] visited;
    static long answer;
    
    public long solution(int[] a, int[][] edges) {
        
        //정점으로부터 이어져있는 간선의 개수가 1인 것 넣어서 처리
        
        N = a.length;
        e = new int[N];
        arr = new long[N];
        edge = new ArrayList[N];
        visited = new boolean[N];
        
        long sum = 0;
        for(int i = 0; i < N; i++){
            edge[i] = new ArrayList<Integer>();
            arr[i] = a[i];
            sum += a[i];
        }
        if(sum != 0){
            return -1;
        }        
        for(int i = 0; i < edges.length; i++){
            int start = edges[i][0];
            int end = edges[i][1];
            edge[start].add(end);
            edge[end].add(start);
            e[start]++;
            e[end]++;
        }
        
        go();
        
        return answer;
    }
    public static void go(){
        
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(e[i] == 1)
                que.add(i);
            
        }
        
        while(!que.isEmpty()){
            int now = que.poll();
            visited[now] = true;
            
            for(int i = 0; i < edge[now].size(); i++){
                //해당 정점에 연결되어있는 애들 뽑아서 방문체크하고
                int next = edge[now].get(i);
                if(visited[next])
                    continue;
                //계산 때리기
                arr[next] += arr[now];
                answer += Math.abs(arr[now]);
                arr[now] = 0;

                //연결되어있는 개수 하나처리하고 연결되어있는 점이 1개이면 큐에 넣기
                e[next]--;
                if(e[next] == 1)
                    que.add(next);
            }
            
            
        }
        
    }
}
