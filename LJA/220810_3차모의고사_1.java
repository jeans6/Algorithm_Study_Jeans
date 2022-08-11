class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int cola = 0;
        int remain = 0;
        while(n >= a) {
            answer = answer + (n/a)*b;
            cola = (n/a)*b;
            remain = n%a;
            n = cola+remain;
        }
        return answer;
    }
}