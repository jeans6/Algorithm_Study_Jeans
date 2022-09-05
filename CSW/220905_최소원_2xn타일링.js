function solution(n) {
    var answer = 0;
    let first = 1;
    let second = 2;
    
    if(n===1){
        return first;
    }else if(n === 2) return second;
    
    for(let i=0; i<n-2; i++){
        answer = (first + second)%1000000007;
        first = second;
        second = answer;
    }
    
    return answer%1000000007;
}