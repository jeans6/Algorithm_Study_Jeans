var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let [R, C, dist] = input[0].split(' ').map(e=>parseInt(e));

const map =Array.from({length:R}, ()=>Array(C).fill(0));
const visited =Array.from({length:R}, ()=>Array(C).fill(0));

for(let i=1; i<=R; i++){
    for(let j=0; j<C; j++){
        if(input[i][j]==='T') map[i-1][j] = 1;
    }
}

const dirY = [1,0,-1,0];
const dirX = [0,1,0,-1];
let cnt = 0;

const dfs = (y, x, dis) =>{
    if(y===0 && x===C-1 && dis ===dist ){
        cnt++;
        return;
    }
    for(let i=0; i<4; i++){
        let dy = y + dirY[i];
        let dx = x + dirX[i];
        if(dy<0 || dx<0|| dy>=R || dx>=C)continue;
        if(visited[dy][dx] || map[dy][dx]) continue;
        visited[dy][dx] = 1;
        dfs(dy,dx, dis+1);
        visited[dy][dx] = 0;
    }
}

visited[R-1][0] =1;
dfs(R-1, 0, 1);


console.log(cnt);

