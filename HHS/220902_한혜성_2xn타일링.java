class Solution {
    static final int div = 1000000007;
    public int solution(int n) {
        int [] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < dp.length; i++){
            dp[i] = (dp[i-1]+dp[i-2]) % div;
        }
        int answer = dp[n];
        return answer;
    }
}