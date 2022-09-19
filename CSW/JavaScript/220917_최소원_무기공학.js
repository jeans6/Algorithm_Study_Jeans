var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let [N, M] = input[0].split(' ').map(e=>parseInt(e));
const material = [];
const visited = Array.from({length:N}, ()=>Array(M).fill(0));
let answer = -1;

const block1 = [[0,1],[1,0]];
const block2 = [[0,-1],[1,0]];
const block3 = [[0,-1],[-1,0]];
const block4 = [[-1,0],[0,1]];

const blocks = [];
blocks.push(block1);
blocks.push(block2);
blocks.push(block3);
blocks.push(block4);


for(let i=0; i<N; i++){
    const col = input[i+1].split(' ').map(e=>parseInt(e));
    material.push(col);
}

function dfs(y, x, sum){
    
    answer = Math.max(answer, sum);

    if(x===M){
        x=0;
        y++;
    }
    if(y===N) return;

    if(!visited[y][x]){
        for(let i=0; i<4; i++){
            let dy1 = y + blocks[i][0][0];
            let dy2 = y + blocks[i][1][0];
            let dx1 = x + blocks[i][0][1];
            let dx2 = x + blocks[i][1][1];
            if(!check(dy1,dx1) || !check(dy2,dx2)) continue;
            if(visited[dy1][dx1] || visited[dy2][dx2]) continue;
            visited[dy1][dx1] = 1;
            visited[dy2][dx2] = 1;
            visited[y][x] = 1;
            dfs(y, x+1, sum + 2*material[y][x] + material[dy1][dx1] + material[dy2][dx2]);
            visited[dy1][dx1] = 0;
            visited[dy2][dx2] = 0;
            visited[y][x] = 0;
        }
        
    }
    dfs(y, x+1, sum);

}

function check(y,x){
    if(y<0 || x<0 || y>=N || x>=M) return false;
    return true;
}

if(N<2 || M<2) console.log(0);
else{
    dfs(0,0,0);
    console.log(answer);
}
    