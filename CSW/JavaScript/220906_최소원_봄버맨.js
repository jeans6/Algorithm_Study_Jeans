var fs = require('fs');
var input = fs.readFileSync(`C://Users/SONG/Desktop/pjt/Algorithm_Study_Jeans/CSW/example.txt`).toString().trim().split('\n');

// row, col, sec
const [R, C, N] = input[0].split(' ').map(e=>parseInt(e));

//direction
const dirY = [-1,0,1,0];
const dirX = [0,1,0,-1];

// 초기 상태
const board = [];
for(let i=0; i<R; i++){
    let col = [];
    for(let j=0; j<C; j++){
        if(input[i+1][j] === 'O') col.push(2);
        else col.push(-1);
    }
    board.push(col);
}

// 폭탄 터짐
const explodeBomb = () =>{
    for(let i=0; i<R; i++){
        for(let j=0; j<C; j++){
            if( board[i][j] !== -1){
                board[i][j] -=1;
            }
        }
    }
    
    const temp = [];
    for(let i=0; i<R; i++){
        let col =[];
        for(let j=0; j<C; j++){
            col.push(board[i][j]);
        }
        temp.push(col);
    }

    for(let i=0; i<R; i++){
        for(let j=0; j<C; j++){
            if(!temp[i][j]){
                board[i][j] = -1;
                for(let z = 0; z<4; z++){
                    let dy = i+dirY[z];
                    let dx = j+dirX[z];
                    if(dy<0 || dx<0|| dy>=R || dx>=C) continue;
                    board[dy][dx] = -1;
                }
            }
        }
    }
}
// 폭탄 설치
const setBomb = () => {
    for(let i=0; i<R; i++){
        for(let j=0; j<C; j++){
            if(board[i][j]===-1) board[i][j] = 3;
            else board[i][j] -= 1;
        }
    }
}

for(let i=2; i<=N; i++){
    if(!(i%2)){
        setBomb();
    }else{
        explodeBomb();
    }
}

let result = '';
board.map(col => {
    col.map(e=>{
        if(e === -1) result += '.';
        else result+= 'O';
    })
    result += '\n';
})



console.log(result);
