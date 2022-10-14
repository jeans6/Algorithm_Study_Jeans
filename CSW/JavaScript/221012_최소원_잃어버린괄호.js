var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let len = input[0].length;
const arr = [];
let temp=0, sum=0;
let answer = 0;

for(let i=0; i<=len; i++){
    if(input[0][i]==='-' || i === len){
        sum += temp;
        arr.push(sum);
        sum = 0;
        temp =0;
    }else if(input[0][i]==='+'){
        sum += temp;
        temp = 0;
    }else{
        temp *= 10;
        temp += parseInt(input[0][i]);
    }
}

for(let i=0; i<arr.length; i++){
    if(!i) answer = arr[i];
    else answer -= arr[i];
}

console.log(answer);
