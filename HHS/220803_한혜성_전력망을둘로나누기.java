import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Line> line;
    
    public int solution(int n, int[][] wires) {

        line = new ArrayList<>();
        for(int i = 0; i < wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            line.add(new Line(start, end, true));
        }
        //하나씩 선 끊어가면서 최솟값 확인
        for(int i = 0; i < line.size(); i++){
            int s = line.get(i).start;
            int e = line.get(i).end;
            line.get(i).check = false;

            bfs(n,s);
            line.get(i).check = true;
        }
        
        return answer;
    }
    private static void bfs(int n, int wire){
        Queue<Integer> que = new LinkedList<>();
        que.add(wire);
        boolean [] visited = new boolean[n+1];
        visited[wire] = true;
        int count = 1;
        
        while(!que.isEmpty()){
            int cur = que.poll();
            
            for(int i = 0; i < line.size(); i++){
                int start = line.get(i).start;
                int end = line.get(i).end;
                boolean check = line.get(i).check;
                if(start == cur && !visited[end] && check){
                    visited[end] = true;
                    count++;
                    que.add(end);
                }else if(end == cur && !visited[start] && check){
                    visited[start] = true;
                    count++;
                    que.add(start);
                }
            }
            
        }
        answer = Math.min(answer, Math.abs(count-(n-count)));
        
    }
}
class Line{
    int start;
    int end;
    boolean check;
    public Line(int start, int end, boolean check){
        this.start = start;
        this.end = end;
        this.check = check;
    }
}