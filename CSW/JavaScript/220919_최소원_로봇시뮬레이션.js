var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

//A 가로, B 세로
let [A , B] = input[0].split(' ').map(e=>parseInt(e));
let [N , M] = input[1].split(' ').map(e=>parseInt(e));

const board = Array.from({length:B}, ()=>Array(A).fill(0));
const robots = [];
const directions = [];
let state = 0;

for(let i=0; i<N; i++){
    let [x, y, dir] = input[2+i].trim().split(' ');
    robots.push([B-parseInt(y), parseInt(x)-1]);
    board[B-parseInt(y)][parseInt(x)-1] = i+1;
    directions[i] = dir;
}

const turnL = (dir) =>{
    if(dir === 'N'){
        return 'W';
    }else if(dir ==='W'){
        return 'S';
    }else if(dir === 'S'){
        return 'E';
    }else if(dir === 'E'){
        return 'N';
    }
}

const turnR = (dir) =>{
    if(dir === 'N'){
        return 'E';
    }else if(dir ==='E'){
        return 'S';
    }else if(dir === 'S'){
        return 'W';
    }else if(dir === 'W'){
        return 'N';
    }
}
const goStraight = (ry, rx, dir) =>{
    if(dir === 'N'){
        return [ry-1, rx];
    }else if(dir ==='W'){
        return [ry, rx-1];
    }else if(dir === 'S'){
        return [ry+1, rx];
    }else if(dir === 'E'){
        return [ry, rx+1];
    }

}


for(let i=0; i<M; i++){
    let [robot, order, num] = input[2+N+i].trim().split(' ');
    let [ry, rx] = robots[parseInt(robot)-1];
    let dir = directions[parseInt(robot)-1];
    let [dy, dx] = [ry, rx];

    for(let j=0; j<parseInt(num); j++){
        if(order === 'L'){
            dir = turnL(dir);
            directions[parseInt(robot)-1] = dir;
        }else if(order === 'R'){
            dir = turnR(dir);
            directions[parseInt(robot)-1] = dir;
        }else if(order === 'F'){
            [dy, dx] = goStraight(ry, rx, dir);
            if(dy<0 || dx <0 || dy>=B || dx>=A){
                state = 1;
                console.log(`Robot ` + robot +` crashes into the wall`);
                break;
            }
            if(board[dy][dx]){
                state = 1;
                console.log(`Robot ` + robot +` crashes into robot ` + board[dy][dx]);
                break;
            }
            board[ry][rx] = 0;
            board[dy][dx] = parseInt(robot);
            robots[parseInt(robot)-1] = [dy, dx];
            [ry, rx] = [dy, dx];
        }
    }
    if(state) break;
}
if(!state){
    console.log('OK');
}
