var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let T = parseInt(input[0]);
let num = 1;
const dirY = [0,-1,0,1];
const dirX = [1,0,-1,0];
let N, M, K, visited, farm;

const DFS = (dy, dx) => {

    for(let i=0; i<4; i++){
        let ny = dy + dirY[i];
        let nx = dx + dirX[i];
        if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
        if(visited[ny][nx] || !farm[ny][nx]) continue;
        visited[ny][nx] = 1;
        DFS(ny, nx);
    }
}

for(let i=0; i<T; i++){
    [M, N, K] = input[num].split(' ').map(e=>parseInt(e));
    farm = Array.from({length:N}, ()=>Array(M).fill(0));
    visited = Array.from({length:N}, ()=>Array(M).fill(0));
    let cnt = 0;

    for(let j=0; j<K; j++){
        let [x, y] = input[num+1+j].split(' ').map(e=>parseInt(e));
        farm[y][x] = 1;
    }

    for(let j=0; j<N; j++){
        for(let z=0; z<M; z++){
            if(!visited[j][z]&&farm[j][z]){
                visited[j][z] = 1;
                DFS(j, z);
                cnt++;
            }
        }
    }
    console.log(cnt);
    num += K + 1;
}