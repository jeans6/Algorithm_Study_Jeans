var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let N = parseInt(input[0]);
let M = parseInt(input[1]);

const result = Array.from({length:N+1}, ()=>Array(N+1).fill(0));

for(let i=2; i<2+M; i++){
    let [big, small] = input[i].split(' ').map(e=>parseInt(e));
    result[big][small] = 1;
}

for(let k=1; k<=N; k++){
    for(let i=1; i<=N; i++){
        for(let j=1; j<=N; j++){
            if(result[i][k] && result[k][j]){
                result[i][j] = 1;
            }
        }
    }
}

for(let i=1; i<=N; i++){
    let cnt = 0;
    for(let j=1; j<=N; j++){
        if(i===j) continue;
        if(!result[i][j]&&!result[j][i]) cnt ++;
    }
    console.log(cnt);
}
