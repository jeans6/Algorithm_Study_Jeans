var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let [N, K] = input[0].split(' ').map(e=>parseInt(e));

const value = [0];
const weight = [0];
const DP = Array.from({length:N+1}, ()=>Array(K+1).fill(0));


for(let i=1; i<=N; i++){
    let [n, k] = input[i].split(' ').map(e=>parseInt(e));
    weight.push(n);
    value.push(k);
}

for(let i=1; i<=N; i++){
    for(let j=1; j<=K; j++){
        if(j-weight[i]>=0) DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j-weight[i]]+value[i]);
        else DP[i][j] = DP[i-1][j];
    }
}



console.log(DP[N][K]);