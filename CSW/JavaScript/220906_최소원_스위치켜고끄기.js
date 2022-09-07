var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().split('\n');
const N = input[0];
const switches = input[1].split(' ').map(e=>parseInt(e));
const people = input[2];
let len = input.length;

let queue = [];

for(let i=3; i<len; i++){
    queue.push(input[i].split(' ').map(e=>parseInt(e)));
}

// 남자일 때, 숫자의 배수 켜거나 끄기
const turnSwitch = (n)=>{

    for(let i=0; i<N; i++){
        if((i+1)%n === 0){
            switches[i] = switches[i] ? 0 : 1;
        }
    }
}

// 여자일 때, 주어진 번호에서 대칭으로 큰 구간 상태 바꾸기
const findTerm = (n) =>{
    let left = n-2;
    let right = n;
    switches[n-1] = switches[n-1] ? 0 : 1;

    while(1){       
        if(left<0 || right>=N) break;
        if(switches[left] !== switches[right]) break;
        switches[left] = switches[left] ? 0 : 1; 
        switches[right] = switches[right] ? 0 : 1; 
        left--;
        right++;

    }
}

for(let i=0; i<people; i++){
    let [gender, n] = queue[i];
    if(gender===1){
        turnSwitch(n);
    }else if(gender===2){
        findTerm(n);
    }
}

for(let i=0; i<Math.ceil(N/20); i++){
    let result = switches.slice(i*20, i*20+20).join(' ');
    console.log(result);
}
