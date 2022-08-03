//62.5점 (시간초과)

import java.util.*;

class Solution {

    static boolean [] visited;
    static int [] cnt;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        cnt = new int[n+1];

        for(int i = 1; i <= n; i++){
            if(i == destination)
                cnt[i] = 0;
            else
                cnt[i] = -1;
        }

        Queue<Integer> que = new LinkedList<>();

        visited = new boolean[n+1];
        visited[destination] = true;
        que.add(destination);

        while(!que.isEmpty()){
            int num = que.poll();
            for(int i = 0; i < roads.length; i++){
                int s = roads[i][0];
                int e = roads[i][1];
                if(!visited[e] && s == num){
                    cnt[e] = cnt[s]+1;
                    visited[e] = true;
                    que.add(e);
                }
                else if(!visited[s] && e == num){
                    cnt[s] = cnt[e]+1;
                    visited[s] = true;
                    que.add(s);
                }
            }
        }

        int[] answer = new int [sources.length];
        for(int i = 0; i < sources.length; i++){
            int count = cnt[sources[i]];
            answer[i] = count;
        }
        return answer;
    }
}