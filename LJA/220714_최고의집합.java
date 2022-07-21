class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        // 각 원소의 곱이 최대가 되려면 결국 각각이 최대로 큰 수여야 함
        int mok = s/n;
        int namuji = s%n;
        // 몫이 0인 경우 -1 리턴
        if(mok == 0) return new int[]{-1};
        // 전체를 몫으로 채움
        for(int i = 0; i < n; i++) answer[i] = mok;
        // 나머지가 있는 경우만 돌아감. 뒤에서 부터 +1 해줌
        for(int i = n-1; i >= n-namuji; i--) {
            answer[i]++;
        }
        return answer;
    }
}