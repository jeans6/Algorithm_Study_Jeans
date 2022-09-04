class Solution {
    public int solution(int n) {
        int answer = 0;
        int dp[] = new int[n+1];
        for(int i = 0; i <= n; i++) {
            if(i < 2) dp[i] = 1;
            else dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }
}