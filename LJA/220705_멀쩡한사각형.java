class Solution {
    public long solution(int w, int h) {
        long g = gcd(w, h);
        // 전체 개수 - 불가능한 사각형 개수(w+h-최대공약수);
        long answer = (long)w*h - (w + h - g);
        return answer;
    }
    
    // 최대공약수 구하기
    private int gcd(int n, int m) {
        while(m != 0) {
            int r = n%m;
            n = m;
            m = r;
        }
        return n;
    }
}
// 참고 https://hidelookit.tistory.com/251