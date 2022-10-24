var fs = require('fs');
var [T, ...inputs] = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let n=0; 

for(let i=0; i<T; i++){
    let N = parseInt(inputs[n]);
    let lists = [];
    for(let j=1; j<=N; j++){
        let temp = inputs[n+j].split(' ').map(e=>parseInt(e));
        lists.push(temp);
    }

    lists.sort((a,b)=> a[0]-b[0]);

    let cnt = 1;
    let temp = lists[0][1];

    for(let j=1; j<lists.length; j++){
        if(temp>lists[j][1]){
            temp =lists[j][1];
            cnt+=1;
        }
    }

    console.log(cnt);
    n += N+1;
}