var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let N =  parseInt(input[0]);
let schedule =[];

for(let i=1; i<=N; i++){
    let temp = input[i].split(' ').map(e=>parseInt(e));
    schedule.push(temp);
}

schedule.sort((a,b)=>{
    if(a[1]===b[1]) return a[0]-b[0];
    return a[1]-b[1];
})

let end = schedule[0][1];
let cnt = 1;

for(let i=1; i<N; i++){
 
    if(schedule[i][0]>= end){
        cnt++;
        end = schedule[i][1];
    }
}


console.log(cnt);