var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let start = 0;

while(1){
    let N = parseInt(input[start]);
    if(!N) break;
    const visited = Array.from({length:N}, ()=>0);
    const rooms = [];
    const fee = [];
    const canGo=[];
    let answer = false;
    for(let i=0; i<N; i++){
        const col = input[i+start+1].trim().split(' ');
        const canGotemp = [];
        for(let j=0; j<col.length-1; j++){
            if(!j){
                rooms.push(col[0]);
            }else if(j===1){
                fee.push(parseInt(col[j]));
            }else{
                canGotemp.push(parseInt(col[j]-1));
            }
        }
        canGo.push(canGotemp);
    }

    
    const dfs = (now, money) =>{
        if(answer) return;
        if(rooms[now] === 'L'){
            if(money<fee[now]){ 
                money += fee[now];
            }
        }else if(rooms[now] === 'T'){
            money -= fee[now];
        }
        
        if(money<0) return;

        if(now === N-1) {
            answer = true;
            return;
        }

        for(let i=0; i<canGo[now].length; i++){
            if(visited[canGo[now][i]]) continue;
            visited[canGo[now][i]] = 1;
            dfs(canGo[now][i], money);
            visited[canGo[now][i]] = 0;
        }

    }

    visited[0] = 1;
    dfs(0, 0);
    if(answer){
        console.log('Yes');
    }else{
        console.log('No');
    }

    start += N+1;
}
