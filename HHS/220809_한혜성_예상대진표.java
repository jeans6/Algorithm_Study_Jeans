class Solution{
    public int solution(int n, int a, int b){
        int answer = 0;

        while(true){
            a = (int) Math.ceil((double) a/2);
            b = (int) Math.ceil((double) b/2);
            answer++;

            if(a == b) break;
        }

        return answer;
    }
}