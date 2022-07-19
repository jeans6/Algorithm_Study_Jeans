function solution(maps) {
    var answer = 0;
    //상 우 하 좌
    const direction = [[-1,0],[0,1],[1,0],[0,-1]];
    const col = maps.length-1;
    const row = maps[0].length-1;
    
    //갈 수 있는 길인지 체크하는 함수
    const isRoad = (x,y,row,col) => {
        if(x<0 || y<0 || x> row ||y>col) return 0;
        else return 1;
    }
    
    //BFS
    // 큐 [y, x, count]
    const queue = [[0,0,1]];
    
    while(queue.length){
        let [y,x,count] = queue.shift();
        //상대진영일 때 최소거리 리턴
        if(y === col && x === row) return count;
        
        for(let i=0; i<4; i++){
            let [dy,dx] = direction[i];
            let nextY = dy+y, nextX = dx+x;
            if(!isRoad(nextX,nextY,row, col)) continue;
            if(maps[nextY][nextX] === 0) continue;
        
            //간 길로 체크 후, 큐에 push
            maps[nextY][nextX] = 0;
            queue.push([nextY,nextX,count+1]);
        }
        
    }
    
    return -1;
}
