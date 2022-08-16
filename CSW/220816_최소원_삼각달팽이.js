function solution(n) {
    var answer = [];
    const snail = Array.from({length:n}, (e, index)=>Array(n).fill(0));
    let col=0, row=0;
    let direct = 1;
    let now = 1;
    for(let i=n; i>0; i--){
        
        for(let j=0; j<i; j++){
            if(direct === 1){
                snail[row][col] = now;
                now++;
                if(j===i-1) {
                    col++;
                    continue;
                }
                row++;
            }else if(direct ===2 ){
                snail[row][col] = now;
                now++;
                if(j===i-1){
                    row--;
                    col--;
                    continue;
                }
                col++;
            }else if(direct ===3){
                snail[row][col] = now;
                now++;
                if(j===i-1){
                    row++;
                    continue;
                }
                row--;
                col--;
            }
        }
        direct++;
        if(direct===4) direct=1;
    }
    
    for(let i=0; i<n; i++){
        for(let j=0; j<=i; j++){
            answer.push(snail[i][j]);
        }
    }

    return answer;
}