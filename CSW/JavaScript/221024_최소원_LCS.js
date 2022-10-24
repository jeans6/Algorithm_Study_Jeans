var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

const [str1, str2] = [input[0], input[1]];
let len1 = str1.length;
let len2 = str2.length;
const check = Array.from({length:len1+1}, ()=> Array(len2+1).fill(0));

for(let i=1; i<=len1; i++){
    for(let j=1; j<=len2; j++){
        if(str1.charAt(i-1) === str2.charAt(j-1)){
            check[i][j] = check[i-1][j-1] +1;
        }else{
            check[i][j] = Math.max(check[i][j-1], check[i-1][j]);
        }
    }
}

console.log(check[len1][len2]);