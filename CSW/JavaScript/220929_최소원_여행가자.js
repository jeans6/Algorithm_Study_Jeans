var fs = require('fs');
var input = fs.readFileSync(`C://Users/SONG/Desktop/pjt/Algorithm_Study_Jeans/CSW/JavaScript/example.txt`).toString().trim().split('\n');

let N = parseInt(input[0]);
let M = parseInt(input[1]);
const stopBy = input[2+N].split(' ').map(e=>parseInt(e));
const root = Array(N+1).fill(0);
const connection = [];


for(let i=0; i<=N; i++){
    root[i] = i;
}


function getParent(num){
    if(root[num] === num) return num;
    return getParent(root[num]);
}

function unionParent(a, b){
    let parentA = getParent(a);
    let parentB = getParent(b);
    if(parentA>parentB) root[a] = parentB;
    else root[b] = parentA;
}

function findParents(a, b){
    let parentA = getParent(a);
    let parentB = getParent(b);
    if(parentA === parentB) return 1;
    return 0; 
}


for(let i=1; i<N+1; i++){
    const connect = input[i+1].split(' ').map(e=>parseInt(e));
    for(let j=0; j<N; j++){
        if(connect[j]) unionParent(i, j+1);
    }
    connection.push(connect);
}

for(let i=1; i<=N; i++){
    for(let j=1; j<=N; j++){
        if(connection[i-1][j-1]) unionParent(i, j);
    }
}

let r = getParent(stopBy[0]);

while(stopBy.length){
    if(findParents(r, stopBy.shift())) continue;
    else {
        r = -1;
        break;
    }
}
if(r === -1) console.log('NO');
else console.log('YES');

