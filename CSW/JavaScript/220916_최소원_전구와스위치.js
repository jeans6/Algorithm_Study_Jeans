var fs = require('fs');
var input = fs.readFileSync(`C://Users/SONG/Desktop/pjt/Algorithm_Study_Jeans/CSW/JavaScript/example.txt`).toString().trim().split('\n');

let N = parseInt(input[0]);
const switches = input[1].trim();
const result = input[2].trim();

const switch1 = [...switches];
const switch2 = [...switches]
let min = Infinity;
let cnt = 0;


// 스위치 눌러주면 바꿔주는 함수
function flip(str, idx){
    if(idx>0 && idx<str.length-1){
        for(let i=idx-1; i<=idx+1; i++){
                str[i] = str[i] === '1' ? '0' : '1';
        }
    }else if(!idx){
        str[idx] = str[idx] === '1' ? '0' : '1';
        str[idx+1] = str[idx+1] === '1' ? '0' : '1';
    }else{
        str[idx] = str[idx] === '1' ? '0' : '1';
        str[idx-1] = str[idx-1] === '1' ? '0' : '1';
    }
}

//첫번째 전구 안누르고 탐색
for(let i=1; i<N; i++){
    if(switch1[i-1] === result[i-1]) continue;
    flip(switch1, i);
    cnt++;
}

if(switch1.join('') === result){
    min = Math.min(min, cnt);
}

//첫번째 전구 누르고 탐색
flip(switch2, 0);
cnt = 1;
for(let i=1; i<N; i++){
    if(switch2[i-1] === result[i-1]) continue;
    flip(switch2, i);
    cnt++;
}

if(switch2.join('') === result){
    min = Math.min(min, cnt);
}


min = min === Infinity ? -1 : min;

console.log(min);