const { verify } = require('crypto');
var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');
const [N, K] = input[0].split(' ').map(e=>parseInt(e));
const kit = input[1].split(' ').map(e=>parseInt(e));
let answer = 0;
const getPermutations = (arr,selectNumber)=>{
    const results=[];
    if(selectNumber === 1) return arr.map(v=>[v]);

    arr.forEach((fixed, index, origin)=>{
        const rest = [...origin.slice(0, index), ...origin.slice(index + 1)];
        const permutation = getPermutations(rest, selectNumber-1);
        const attached = permutation.map(e=>[fixed,...e]);
        results.push(...attached);
    })
    return results;
}

const result = getPermutations(kit, N);

for(let i=0; i<result.length; i++){
    let buffer = 0;
    let flag = 0;
    for(let j=0; j<result[0].length; j++){
        if(result[i][j]>=K){
            buffer += result[i][j]-K;
        }else{
            buffer += result[i][j]-K;
            if(buffer<0) {
                flag =1;
                break;
            }
        }
    }
    if(flag) continue;
    answer++;
}

console.log(answer);