var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let N = parseInt(input[0]);
const lines = [];

for(let i=1; i<=N; i++){
    let temp = input[i].split(' ').map(e=>parseInt(e));
    lines.push([temp[0],1]);
    lines.push([temp[1],-1]);
}

lines.sort((a,b)=>{
    if(a[0]===b[0]) return a[1]-b[1];
    return a[0]-b[0];
})

let cnt = 0;
let answer = 0;
for(let i=0; i<lines.length; i++){
    cnt += lines[i][1];
    answer = Math.max(answer, cnt);
}


console.log(answer);