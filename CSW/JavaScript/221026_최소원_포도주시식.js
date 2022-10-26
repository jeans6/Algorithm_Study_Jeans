var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let N = parseInt(input[0]);
const wines = [0];
const DP = Array.from({length:N+1}, ()=> 0);

for(let i=1; i<=N; i++){
    wines.push(parseInt(input[i]));
}

DP[1] = wines[1];
DP[2] = DP[1] + wines[2];

for(let i=3; i<=N; i++){
    DP[i] = Math.max(DP[i-3]+wines[i-1]+wines[i], DP[i-2]+wines[i]);
    DP[i] = Math.max(DP[i-1], DP[i]);
}


console.log(DP[N]);