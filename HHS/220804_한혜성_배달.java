import java.util.*;

class Solution {
    static int answer;
    static ArrayList<Road>[] roads;
    static int [] times;
    static int n;
    public int solution(int N, int[][] road, int K) {
        n = N;
        roads = new ArrayList[N+1];
        times = new int[N+1];
        
        for(int i = 1; i <= N; i++){
            roads[i] = new ArrayList<Road>();
            times[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < road.length; i++){
            int start = road[i][0];
            int end = road[i][1];
            int time = road[i][2];
            roads[start].add(new Road(end, time));
            roads[end].add(new Road(start, time));
        }
        delivery();
        for(int i = 1; i <= N; i++){
            if(times[i] <= K)
                answer++;
        }
        
        return answer;
    }
    private static void delivery(){
        
        PriorityQueue<Road> que = new PriorityQueue<Road>(
        (o1, o2) -> Integer.compare(o1.time, o2.time));
        
        boolean [] visited = new boolean[n+1];
        
        que.add(new Road(1, 0));
        times[1] = 0;
        
        while(!que.isEmpty()){
            Road r = que.poll();
            int cur = r.end;
            
            if(visited[cur])
                continue;
            
            visited[cur] = true;
            
            for(int i = 0; i < roads[cur].size(); i++){
                Road next = roads[cur].get(i);
                if(times[next.end] > times[cur] + next.time){
                    times[next.end] = times[cur] + next.time;
                    que.add(new Road(next.end, times[next.end]));
                }
            }
            
        }
        
    }
}
class Road implements Comparable<Road>{
    int end;
    int time;
    public Road(int end, int time){
        this.end = end;
        this.time = time;
    }
    @Override
    public int compareTo(Road r){
        return this.time - r.time;
    }
}