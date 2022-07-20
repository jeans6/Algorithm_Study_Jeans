function solution(n, s) {
    var answer = [];

    // 자연수의 갯수 n이 s보다 커지면 -1를 반환
    if(n>s) return [-1];
    
    // 곱해지는 수의 차가 작을수록 곱은 커짐
    for(let i=0; i<n; i++){
        let num = Math.floor(s/(n-i));
        answer.push(num);
        s -= num;
    }
    
    return answer;
}