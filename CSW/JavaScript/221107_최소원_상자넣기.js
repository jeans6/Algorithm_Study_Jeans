var fs = require('fs');
var [N, str] = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');


const arr = str.split(' ').map(e=>Number(e));

const DP = Array.from({length:N}, ()=>1);
let answer = 0;

for(let i=1; i<N; i++){
    let box = 0;
    for(let j=0; j<i; j++){
        if(arr[j]<arr[i]) {
            box = Math.max(DP[j], box);
        }
    }
    DP[i] += box;
    answer = Math.max(answer, DP[i]);
}

console.log(answer);
