#include <stdio.h>
#define max(a, b) a > b ? a : b
int dp[1001][1001];
int main(){
    char str[2][1001];
    scanf("%s %s", &str[0], &str[1]);
    int i, j;
    for (i = 0; str[0][i]; i++)
        for (j = 0; str[1][j]; j++)
            if (str[0][i] == str[1][j]) dp[j+1][i+1] = dp[j][i] +1;
            else dp[j+1][i+1] = max(dp[j][i+1], dp[j+1][i]);
			
    printf("%d", dp[j][i]);
}