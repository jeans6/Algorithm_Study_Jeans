var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let N = parseInt(input[0]);
const board = [];
const teacher = [];
const empty = [];
const dirY = [-1,0,1,0];
const dirX = [0,1,0,-1];
let possible = 0;

for(let i=0; i<N; i++){
    const col = input[1+i].trim().split(' ');
    for(let j=0; j<col.length; j++){
        if(col[j]==='X'){
            empty.push([i,j]);
        }else if(col[j]==='T'){
            teacher.push([i,j]);
        }
    }
    board.push(col);
}

function find(){

    for(let i=0; i<teacher.length; i++){
        let ty = teacher[i][0];
        let tx = teacher[i][1];
        for(let j=0; j<4; j++){
            let dy = ty;
            let dx = tx;
            while(1){
                dy += dirY[j];
                dx += dirX[j];
                if(dy<0||dx<0|| dy>=N||dx>=N || board[dy][dx] === 'O') break;
                // 학생들이 감시 피하는거 실패
                if(board[dy][dx] === 'S'){
                    return false;
                }
            }
        }
    }
    // 감시피하기 성공
    return true;
}

function dfs(level){
    if(level === 3){
        if(find()) possible = 1;
        return;
    }

    for(let i=0; i<empty.length; i++){
        let y = empty[i][0];
        let x = empty[i][1];
        if(board[y][x] ==='X'){
            board[y][x] = 'O';
            dfs(level+1);
            board[y][x] = 'X';
        }
    }

}


dfs(0);

if(possible) console.log("YES");
else console.log("NO");

