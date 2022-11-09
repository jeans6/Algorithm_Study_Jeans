var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let [N, M] = input[0].split(' ').map(e=>parseInt(e));
let answer = N;
const word = {};
let flag = 0;
let result = '';
for(let i=1; i<=N; i++){
    word[input[i]] = 1;
}

for(let i=N+1; i<=N+M; i++){
    let temp = input[i].split(',');
    if(flag){
        console.log(0);
        continue;
    }
    for(let j=0; j<temp.length; j++){
        if(word[temp[j]] === 1){
            word[temp[j]] = 0;
            answer--;
            if(!answer){
                flag = 1;
                break;
            }
        }
    }   
    result += answer + '\n';
}

console.log(result);