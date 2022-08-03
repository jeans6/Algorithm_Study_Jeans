function solution(n) {
    let answer = '';
    const world124 = ['4', '1', '2'];
    
    //3진법인데 3 -> 4 치환
    //나머지가 0이면 n에 몫에서 1 빼준 값 할당
    while(n>0){
        let m = n%3;
        answer = world124[m] + answer;
        n = n%3 === 0? n/3-1 : Math.floor(n/3);
    }
        
    return answer;
}