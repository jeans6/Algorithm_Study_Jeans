#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// A_len은 배열 A의 길이입니다.
// B_len은 배열 B의 길이입니다.

int compare(const void *a, const void*b){
    //숫자정렬(오름차순)
    if(*(int*)a>*(int*)b) return 1;
    else if(*(int*)a<*(int*)b) return -1;
    else return 0;

    //문자정렬(오름차순)
    //return strcmp((char*)a, (char*)b);
}
int solution(int A[], size_t A_len, int B[], size_t B_len) {
    int answer = 0;

    qsort(A, A_len, sizeof(A[0]), compare);
    qsort(B, B_len, sizeof(B[0]), compare);

    
    for(int i=0; i<A_len; i++){
        answer += A[i]*B[B_len-1-i];      
    }
    
    
    return answer;
}