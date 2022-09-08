var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

const [R, C] = input[0].split(' ').map(e=>parseInt(e, 10));

// directions
const dirY = [1,0,-1,0,1,1,-1,-1];
const dirX = [0,1,0,-1,1,-1, 1,-1];

// map 초기 설정
const map =[];
for(let i=1; i<=R; i++){
    const col = input[i].split(' ').map(e=>parseInt(e));
    map.push(col);
}

let queue =[];

for(let i=0; i<R; i++){
    for(let j=0; j<C; j++){
        if(map[i][j]) queue.push([i,j]);
    }
}

let answer = 0;

while(queue.length){
    let [y,x] = queue.shift();

    for(let i=0; i<8; i++){
        let dy = y + dirY[i];
        let dx = x + dirX[i];
        if(dy<0||dx<0||dy>=R||dx>=C) continue;
        if(map[dy][dx]) continue;
        map[dy][dx] = map[y][x] + 1;
        answer = Math.max(answer, map[dy][dx]);
        queue.push([dy, dx]);
    }
}



console.log(answer-1);