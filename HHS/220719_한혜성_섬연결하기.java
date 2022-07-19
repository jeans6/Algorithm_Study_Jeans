import java.io.*;
import java.util.*;

class Solution {
    
    static Edge [] island;
    static int answer;
    static int [] parents;    
    
    public int solution(int n, int[][] costs) {
        
        //값이 작은 애들 순서로 정렬 후 
        //유니온 파인드로 묶기
        
        parents = new int[n+1];
        island = new Edge[costs.length];

        for(int i = 0; i < costs.length; i++){
            island[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
        }
        //간적크 간만프
        //크루스칼 이용하여 값 구하기
        kruskal();
        
        
        return answer;
    }
    private static void kruskal(){
        int count = 0;//모든 점 돌았는지 확인
        Arrays.sort(island);
        
        make();//자기 자신 부모로 하기
        
        for(int i = 0; i < island.length; i++){
            
            if(union(island[i].from, island[i].to)){
                //부모 다르면 합치고 값 더하고 카운트 올리기
                answer += island[i].cost;
                count++;
            
                //다돌았으면 나가
                if(count == parents.length-2)
                    return;
            }
        }
        
    }
    //자기 자신을 일단 부모로 만들기
    private static void make(){
        for(int i = 1; i < parents.length; i++){
            parents[i] = i;
        }
    }
    
    //부모 다르면 합치기(부모 옮기기)
    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        
        if(aRoot == bRoot)
            return false;
        
        parents[aRoot] = bRoot;
        return true;
        
    }
    //부모 찾기
    private static int find(int a){
        if(a == parents[a])
            return a;
        return parents[a] = find(parents[a]);
    }    
    
}
class Edge implements Comparable<Edge>{
    int from;
    int to;
    int cost;
    
    public Edge(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge o){
        return Integer.compare(this.cost, o.cost);
    }
}