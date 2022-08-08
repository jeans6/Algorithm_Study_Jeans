function solution(rectangle, characterX, characterY, itemX, itemY) {
    const map = Array.from({length:103},()=>Array(103).fill(0));

    //전체 좌표를 두배로 해줌
    const doubleRec = rectangle.map(e=> e.map(v=> v*2));
    characterX *= 2;
    characterY *= 2;
    itemX *= 2;
    itemY *= 2;
    
    
    //테두리 작업해주기
    doubleRec.forEach(e=>{
        let [lx,ly,hx,hy] = e;
        
        //테두리만 1로
        for(let i=ly; i<=hy; i++){
            for(let j=lx; j<=hx; j++){
               if(i===ly || i===hy || j ===lx || j===hx){
                   if(map[i][j] === 1){
                       continue;
                   }else{
                       map[i][j] += 1;
                   }
               }else{
                   map[i][j] = 2;
               }
            }
        }
    })
    
    let queue = [[characterX, characterY, 0]];
    const direction = [[-1,0],[1,0],[0,1],[0,-1]];
    map[characterY][characterX] += 100;
    
    while(queue.length){
        let [nowX, nowY, count] = queue.shift();

        if(nowX===itemX && nowY === itemY){
            return count/2;
        }
        
        for(let i=0; i<4; i++){
            let nextX = nowX + direction[i][1];
            let nextY = nowY + direction[i][0];
            if(nextX<0 || nextY<0 || nextX>=103 || nextY >=103) continue;
            if(map[nextY][nextX] === 1){
                map[nextY][nextX] += 100;
                queue.push([nextX, nextY, count+1]);
            }
        }
    }
    
}