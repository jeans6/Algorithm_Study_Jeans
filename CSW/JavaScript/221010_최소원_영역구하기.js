var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let [M, N, K] = input[0].split(' ').map(e=>parseInt(e));

const board = Array.from({length:M*2}, ()=> Array(N*2).fill(0));

const dirY = [1,0,-1,0];
const dirX = [0,1,0,-1];
const visited = Array.from({length:M*2}, ()=> Array(N*2).fill(0));
const answer =[];
let len = 1;

for(let i=0; i<K; i++){
    let [x1, y1, x2, y2] = input[1+i].split(' ').map(e=>parseInt(e));

    for(let j = 2*y1; j<2*y2; j++){
        for(let z=2*x1; z<2*x2; z++){
            board[j][z] = 1;
        }
    }

}

const dfs = (dy, dx) =>{

    for(let i=0; i<4; i++){
        let ny = dy + dirY[i];
        let nx = dx + dirX[i];
        if(ny<0 || nx<0 || ny>=2*M || nx>=2*N) continue;
        if(visited[ny][nx] || board[ny][nx]) continue;
        visited[ny][nx] = 1;
        len++;
        dfs(ny, nx); 
    }
}

for(let i=0; i<2*M; i++){
    for(let j=0; j<2*N; j++){
        if(!visited[i][j] && !board[i][j]){
            len = 1;
            visited[i][j] = 1;
            dfs(i, j);
            answer.push(len/4);
        }
    }
}

answer.sort((a,b)=>a-b);

console.log(answer.length);
console.log(answer.join(' '));