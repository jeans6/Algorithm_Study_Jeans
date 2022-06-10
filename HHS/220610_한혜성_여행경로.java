package HHS;

import java.util.*;

class Solution {
    static ArrayList<String> plane;
    static boolean [] visited;
    
    public String[] solution(String[][] tickets) {
        plane = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        //카운트 == 티켓길이만큼 되면 총 경로 출력
        dfs(0, "ICN", "ICN", tickets);
        
        //알파벳 순서로 정렬한 후 첫번째 리스트 뽑아내기
        Collections.sort(plane);
        
        String[] answer = plane.get(0).split(" ");
        return answer;
    }
    static void dfs(int count, String start, String ways, String[][] tickets){
        if(count == tickets.length){
            plane.add(ways);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            //방문했으면 나가
            if(visited[i]) continue;
            //출발지가 다르면 나가
            if(!tickets[i][0].equals(start)) continue;
            
            visited[i] = true;
            dfs(count+1, tickets[i][1], ways+ " " + tickets[i][1], tickets);
            visited[i] = false;
            
        }
        
    }
}