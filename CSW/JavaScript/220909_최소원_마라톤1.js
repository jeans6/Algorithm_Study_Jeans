var fs = require('fs');
var input = fs.readFileSync(`C://Users/SONG/Desktop/pjt/Algorithm_Study_Jeans/CSW/JavaScript/example.txt`).toString().trim().split('\n');

const N = parseInt(input[0]);
const point = [];
let total = 0;
let maxG = 0;

for(let i=1; i<=N; i++){
    point.push(input[i].split(' ').map(e=>parseInt(e)));
}

// 총 거리 계산
for(let i=1; i<N; i++){
    let dist = Math.abs(point[i][0]-point[i-1][0]) + Math.abs(point[i][1]-point[i-1][1]);
    total+=dist;
}

//포인트 거쳐갈 때와 직선으로 갈 때 차이가 큰 경우 찾기
for(let i=1; i<N-1; i++){
    let gap = Math.abs(point[i][0]-point[i-1][0]) + Math.abs(point[i][1]-point[i-1][1])+ Math.abs(point[i][0]-point[i+1][0]) + Math.abs(point[i][1]-point[i+1][1]);
    let straight = Math.abs(point[i+1][0]-point[i-1][0]) + Math.abs(point[i+1][1]-point[i-1][1]);
    let pass = Math.abs(gap-straight);
    if(maxG<pass) maxG = pass;
}

let answer = total - maxG;

console.log(answer);