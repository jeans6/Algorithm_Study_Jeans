class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 학생별 체육복 수를 저장하기 위한 배열 생성 후
        // lost인 경우 -1, reserve인 경우 +1 해줌
        int[] arr = new int[n];
        for(int i : lost) arr[i-1]--;
        for(int i : reserve) arr[i-1]++;
        
        // 체육복을 잃어버린 경우 앞과 뒤 학생이 체육복이 있는지 확인 후 빌림
        for(int i = 0; i < n; i++) {
            if(arr[i] == -1) {
                if(i-1 >= 0 && arr[i-1] > 0) {
                    arr[i-1]--;
                    arr[i]++;
                } else if(i+1 < n && arr[i+1] > 0) {
                    arr[i+1]--;
                    arr[i]++;
                }
            }
        }        
        int answer = 0;
        for(int i : arr) {
            if(i >= 0) answer++;
        }
        return answer;
    }
}