function solution(grid) {
    var answer = [];
    let [N,M] = [grid.length,grid[0].length];
    const routes = {};
    
    // 방향별 방문여부를 위한 배열 초기화 
    for(let i=0; i<N; i++){
        routes[i] = {};
        for(let j=0; j<M; j++){
            routes[i][j] = {
                up:0,
                down:0,
                left:0,
                right:0,
            };
        }
    }
    
    const bfs = (start, end, direction) => {
        let queue = [[start, end, direction, 0]];
        
        while(queue.length){
            let [s, e, d, len] = queue.shift();
            
            //배열의 끝에 닿으면 반대쪽 끝으로 바꿔줌
            s = s<0? N-1 : s===N ? 0 : s;
            e = e<0? M-1 : e===M ? 0 : e;
            
            //시작 포인트와 방향이 같으면 리턴
            if(s === start && e === end && d === direction && len){
                return len;
            }

            routes[s][e][d] = 1;
            
            switch(grid[s][e]){
                case 'S':
                    if(d === 'up'){
                        queue.push([s-1, e, 'up', len+1]);
                    }else if(d === 'left'){
                        queue.push([s, e-1, 'left', len+1]);
                    }else if(d === 'right'){
                        queue.push([s, e+1, 'right', len+1]);
                    }else if(d === 'down'){
                        queue.push([s+1, e, 'down', len+1]);
                    }
                    break;
                case 'L':
                    if(d === 'up'){
                        queue.push([s, e-1, 'left', len+1]);
                    }else if(d === 'left'){
                        queue.push([s+1, e, 'down', len+1]);
                    }else if(d === 'right'){
                        queue.push([s-1, e, 'up', len+1]);
                    }else if(d === 'down'){
                        queue.push([s, e+1, 'right', len+1]);
                    }
                    break;
                case 'R':
                    if(d === 'up'){
                        queue.push([s, e+1, 'right', len+1]);
                    }else if(d === 'left'){
                        queue.push([s-1, e, 'up', len+1]);
                    }else if(d === 'right'){
                        queue.push([s+1, e, 'down', len+1]);
                    }else if(d === 'down'){
                        queue.push([s, e-1, 'left', len+1]);
                    }
                    break;
            }    
            
        }
    }
    
    const directions =['up', 'down', 'left', 'right'];
    for(let i=0; i<N; i++){
        for(let j=0; j<M; j++){
            directions.map(dir =>{
                if(!routes[i][j][dir]){
                    // console.log(routes[i][j][dir]);
                    answer.push(bfs(i, j, dir));   
                }
            })
        }
    }
    
    answer.sort((a,b)=> a-b);
    
    return answer;
}