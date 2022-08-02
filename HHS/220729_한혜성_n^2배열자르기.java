class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        int cnt = 0;
        for(long i = left; i <= right; i++){
            int a = (int)(i / n);
            int b = (int)(i % n);
            if(b <= a)
                answer[cnt] = a+1;
            else
                answer[cnt] = b+1;
            cnt++;
        }
        
        return answer;
    }
}