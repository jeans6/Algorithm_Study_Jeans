class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while(true){
            int cola = n/a * b;
            answer += cola;
            n -= (n/a) * a;
            n += cola;
            if(n < a)
                break;
        }

        return answer;
    }
}