var fs = require('fs');
var input = fs.readFileSync(`C://Users/SONG/Desktop/pjt/Algorithm_Study_Jeans/CSW/JavaScript/example.txt`).toString().trim().split('\n');

let N = parseInt(input[0]);
let energy = 0;
const barn = [];
const distance = Array.from({length:N}, ()=>0);
for(let i=1; i<=N; i++){
    barn.push(parseInt(input[i]));
}


// 소가 있는 인덱스 찾기
function isCow(blankP){
    for(let i=blankP-1; i>=0; i--){
        if(barn[i]){
            barn[i] -=1;
            barn[blankP] += 1;
            distance[blankP] = blankP-i + distance[i];
            return;
        }
    }
    for(let i=N-1; i>blankP; i--){
        if(barn[i]){
            barn[i] -=1;
            barn[blankP] += 1;
            distance[blankP] = N-i+blankP + distance[i];
            return;
        }
    }
}



while(barn.some(e=>e>=2)){
    // 반시계방향으로 빈칸이 있는지 검사
    for(let i=N-1; i>=0; i--){
        let moreTwo = barn.some(e=>e>=2);
        if(!barn[i] && moreTwo){
            isCow(i);
        }
    }
}

for(let i=0; i<distance.length; i++){
    energy += distance[i] * distance[i];
}

console.log(energy);