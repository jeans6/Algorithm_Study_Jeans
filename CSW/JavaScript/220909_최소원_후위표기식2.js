var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');
const N = parseInt(input[0]);
let str = input[1].trim();
const num = [];
const stack = [];


for(let i=2; i<=N+1; i++){
    num.push(parseInt(input[i]));
}

for(let i=0; i<str.length; i++){
    if(str[i]>='A'&&str[i]<='Z'){
        stack.push(num[str[i].charCodeAt()-65]);
    }else{
        let second = stack.pop();
        let first = stack.pop();
        let val = 0;
        switch(str[i]){
            case '+': 
                val = first + second; 
                stack.push(val);
                break;
            case '-': 
                val = first - second;
                stack.push(val);
                break;
            case '*': 
                val = first * second;
                stack.push(val);
                break;
            case '/': 
                val = first / second;
                stack.push(val);
                break;
        }
        
    }
}

let answer = stack.shift().toFixed(2);

console.log(answer);
