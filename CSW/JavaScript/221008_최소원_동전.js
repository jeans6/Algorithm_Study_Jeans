var fs = require('fs');
const { emitKeypressEvents } = require('readline');
var input = fs.readFileSync(`C://Users/SONG/Desktop/pjt/Algorithm_Study_Jeans/CSW/JavaScript/example.txt`).toString().trim().split('\n');

let T = parseInt(input[0]);

for(let i=0; i<T; i++){
    let N = parseInt(input[i*3+1]);
    const coin = input[i*3+2].split(' ').map(e=>parseInt(e));
    let K = parseInt(input[i*3+3]);
    const DP = Array.from({length:K+1}, ()=>0);

    DP[0] = 1;

    for(let i=0; i<N; i++){
        for(let j=coin[i]; j<=K; j++){
            if(j-coin[i]>=0){
                DP[j] += DP[j-coin[i]];
            }
        }
    }

    console.log(DP[K]);
}