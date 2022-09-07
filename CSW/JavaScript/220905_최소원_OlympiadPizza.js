var fs = require("fs");
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');


const N = parseInt(input[0]);
const queue = input[1].split(' ').map(e=>parseInt(e));
const answer = Array.from({length:N}, ()=>0);
let order =0;

queue.map((e, index)=>{
    queue[index] = [e, index];
})

while(queue.length){
    let [num, idx] = queue.shift();
    num -= 1;
    order++;
    if(!num){
        answer[idx] = order;
        continue;
    }
    queue.push([num, idx]);

}

let result = answer.join(' ');

console.log(result);

