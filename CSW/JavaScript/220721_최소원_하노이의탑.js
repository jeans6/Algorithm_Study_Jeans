function solution(n) {
    const answer = [];
    // 1. 1->2로 n-1개를 옮김
    // 2. 1->3으로 가장 큰 1개를 옮김
    // 3. 2->1로 n-2개를 옮김
    // 4. 2->3으로 2번에 있는 것 중 가장 큰 1개를 옮김
    // 의 반복

    // 결국 무엇이든  a -> b 로 n 를 옮기는 동작의 반복이므로 이를 재귀로 표현.
    // a->b 로 n 을 옮기는 것은 a->c로 n-1개를 옮겨놓고, a->b로 하나를 옮긴 후, c->b로 n-1개를 옮기는 것의 반복
    const hanoi = (n,start, end, mid) =>{
        if(n===1) answer.push([start,end]);
        else{
            hanoi(n-1, start, mid, end);
            answer.push([start, end]);
            hanoi(n-1, mid, end, start);
        }
    }
    
    hanoi(n, 1,3,2);
    return answer;
}