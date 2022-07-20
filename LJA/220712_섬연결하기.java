import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        // 부모노드 초기화
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        // 비용 오름차순으로 정렬
        Arrays.sort(costs, (o1, o2)->o1[2]-o2[2]);
        int answer = 0;
        for(int i = 0; i < costs.length; i++) {
            // 써클을 만들지 않으면 연결
            if(findParent(costs[i][0], costs[i][1]) == 0) {
                unionParent(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }
    
    // 현재 노드의 부모를 리턴해주는 함수
    public static int getParent(int x) {
        if(x == parent[x]) return x;
        else return getParent(parent[x]);
    }
    
    public static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    
    public static int findParent(int a, int b) {
        if(getParent(a) == getParent(b)) return 1;
        else return 0;
    }
}