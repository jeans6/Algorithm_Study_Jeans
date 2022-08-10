class Solution
{
    int answer;
    public int solution(int n, int a, int b)
    {
        answer = 1;
        if(a > b) win(n, b, a);
        else win(n, a, b);
        return answer;
    }
    
    void win(int n, int a, int b) {
        if(a%2 != 0 && a+1 == b) return;
        answer++;
        a = (a%2 == 0 ? a/2 : (a+1)/2);
        b = (b%2 == 0 ? b/2 : (b+1)/2);
        win(n/2, a, b);
    }
}