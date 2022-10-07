var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let [N, K] = input[0].split(' ').map(e=>parseInt(e));

const board = Array(100001).fill(0);
const visited = Array(100001).fill(0);
const queue = [];

if(N===K) console.log(0);
else if(N>K){
    console.log(N-K);
}
else{
    
    visited[N] = 1;
    queue.push(N);
    board[N] = 0;

    while(queue.length){
        let now = queue.shift();
    
        if(now === K) {
            console.log(board[K]);
            break;
        }
        if(!visited[now-1] && now-1>=0){
            visited[now-1] = 1;
            queue.push(now-1);
            board[now-1] = board[now]+1;
        }
        if(!visited[now+1] && now+1<=100000){
            visited[now+1] = 1;
            queue.push(now+1);
            board[now+1] = board[now]+1;       
        }
        if(!visited[now*2] && now*2<=100000){
            visited[now*2] = 1;
            queue.push(now*2);
            board[now*2] = board[now]+1;    
        }
    
    }
}
