class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int min = len-1; // 한쪽으로 쭉쭉 이동했을 때 최대 수
        
        for(int i = 0; i < len; i++) {
            char c = name.charAt(i);
            // 상하이동
            answer += Math.min(c-'A', 'Z'-'A'-(c-'A')+1);
            
            // 좌우이동
            int idxA = i + 1;
            // A가 연속해서 나오는 개수를 카운트
            while(idxA < len && name.charAt(idxA) == 'A') idxA++;
            min = Math.min(min, i * 2 + (len - idxA)); // 오른쪽으로 갔다 다시 왼쪽으로 꺾기 // ex) BBAAAAAYYY 
            min = Math.min(min, i + (len - idxA) * 2); // 왼쪽으로 갔다 다시 오른쪽으로 꺾기 ex) CCCAAAAAAY
        }
    
        return answer+min;
    }
}