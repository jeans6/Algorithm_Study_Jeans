var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let K = parseInt(input[0]);
let [W, H] = input[1].split(' ').map(e=>parseInt(e));

const map = [];
const visited = Array.from({length:H}, ()=>Array(W).fill(-1));


const dx = [ 1, -1, 0, 0 ];
const dy = [ 0, 0, 1, -1 ];

const kdx = [ 2, 2, -2, -2, 1, 1, -1, -1 ];
const kdy = [ 1, -1, 1, -1, 2, -2, 2, -2 ];

let queue = [];
let flag = 0;

queue.push([0,0,K,0]);
visited[0][0] = K;

for(let i=0; i<H; i++){
    let temp = input[2+i].split(' ').map(e=>parseInt(e));
    map.push(temp);
}


while(queue.length){
    let [x, y, cnt, dist] = queue.shift();

    if (x === W - 1 && y === H - 1) {
        console.log(dist);
        flag = 1;
        break;
    }
    


    for (let i = 0; i < 8; i++) {
        let nx = x + kdx[i];
        let ny = y + kdy[i];
        if (ny < 0 || nx <0 || nx >= W || ny >= H) continue;
        if (map[ny][nx]) continue;
        if (!cnt) break;
        if (visited[ny][nx] >= cnt -1 ) continue;
        visited[ny][nx] = cnt -1 ;
        queue.push([nx, ny, cnt - 1, dist + 1]);
    }
    
    for (let i = 0; i < 4; i++) {
        let nx = x + dx[i];
        let ny = y + dy[i];
        if (ny < 0 || nx <0 || nx >= W || ny >= H) continue;
        if (map[ny][nx]) continue;
        if (visited[ny][nx] >= cnt) continue;
        visited[ny][nx]= cnt;
        queue.push([nx, ny, cnt, dist + 1]);
    }

}

if(!flag) console.log(-1);