var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

const [N, party] = input[0].split(' ').map(e=>parseInt(e));
const knowInfo = input[1].split(' ').map(e=>parseInt(e));
let knowN = knowInfo.shift();
let answer = 0;

const parent = Array.from({length:N+1}, ()=>0);
//부모가 자기자신을 가르키도록 초기화
for(let i =0; i<parent.length; i++){
    parent[i] = i;
}
//Union-Find
const getParent = (x)=>{
    if(parent[x] === x) return x;
    return getParent(parent[x]);
}

const unionParent = (a,b)=>{
    a = getParent(a);
    b = getParent(b);
    if(a>b) parent[a] = b;
    else parent[b] = a;
}

const findParent = (a,b) =>{
    a = getParent(a);
    b = getParent(b);
    if(a===b) return 1;
    else return 0;
}


for(let i=0; i<knowN; i++){
    // 진실 아는 사람들의 부모를 -1로 통일
    parent[knowInfo[i]] = 0;
}

// 진실을 아는 사람과 엮여있는 인물들의 부모를 0으로
for(let i=0; i<party; i++){
    const attend = input[2+i].split(' ').map(e=>parseInt(e));
    let attendN = attend.shift();
    for(let j=0; j<attendN-1; j++){
        if(!findParent(attend[j], attend[j+1])){
            unionParent(attend[j], attend[j+1]);
        }
    }
}

for(let i=0; i<party; i++){
    const attend = input[2+i].split(' ').map(e=>parseInt(e));
    let attendN = attend.shift();
    let result = false;
    for(let j=0; j<attendN; j++){
        if(getParent(attend[j])){
            // 진실을 모르는 사람이 있는 경우
            result = true;
            break;
        }
    }
    if(result) answer++;
}



console.log(answer);