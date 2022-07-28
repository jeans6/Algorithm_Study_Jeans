function solution(n, left, right) {
    var answer = [];
    let point = -1;
    
    // 일차원배열로 넣기 위한 식
    // 60점 ( 나머지 시간초과 )
    // for(let i=1; i<=n; i++){
    //     for(let j=1; j<=i; j++){
    //         point++;
    //         if(point<left)continue;
    //         if(point>right) return answer;
    //         if(point>=left)answer.push(i);
    //     }
    //     for(let a=1; a<=n-i; a++){
    //         point++;
    //         if(point<left)continue;
    //         if(point>right) return answer;
    //         if(point>=left)answer.push(i+a);
    //     }     
    // }
   
    //규칙찾기 문제였구만....
    for(let i=left;i<=right; i++){
        
        answer.push(Math.max(Math.floor(i/n), i%n)+1);
        
    }
    
    return answer;
}