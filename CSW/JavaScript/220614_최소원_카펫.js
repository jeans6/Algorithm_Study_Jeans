function solution(brown, yellow) {
    var answer = [];
    let total = brown + yellow;
    let n = Math.sqrt(yellow);
    
    for(let i=1; i<=n; i++){
        //갈색과 노란색은 가로,세로가 모두 2씩 차이남
        //노란색의 가로,세로의 경우의 수를 먼저 구해서 2씩 더하고 전체 갯수와 비교
        let row = yellow/i + 2;
        let col = i + 2;
        if(row*col === total){
            answer.push(row,col);
        }
    }
    
    return answer;
}