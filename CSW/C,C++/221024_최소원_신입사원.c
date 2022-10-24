#include <stdio.h>

int lists[100000][2];
int T, N, cnt, x;

int main(){

    scanf("%d", &T);

    for(int i=0; i<T; i++){
        scanf("%d", &N);
        cnt = 1;
        for(int j = 0; j<N; j++){
            int a, b;
            scanf("%d %d", &a, &b);
            lists[a-1][0] = a;
            lists[a-1][1] = b;
        }
        x = lists[0][1];
        for(int j=1; j<N; j++){
            if(x>lists[j][1]){
                x=lists[j][1];
                cnt+=1;
            }
        }
        printf("%d\n", cnt);
    }
    return 0;
}