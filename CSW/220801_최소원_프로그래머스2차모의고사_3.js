function solution(n, roads, sources, destination) {
    const distanceBox = [];
    // 시간초과 (50점)
    const tree = Array.from({length:n+1},()=>new Array());
    
    roads.map(e=>{
        let [inRoad, outRoad] = e;
        tree[inRoad].push(outRoad);
        tree[outRoad].push(inRoad);
    });

    // destination에 도착하지 못할 경우 너무 많은 시간이 걸리기 때문에
    // destination에서 해당 장소까지의 거리를 구해서 한번에 answer로 푸시하는 방향이 맞는 것 같기도
    for(let i=0; i<sources.length; i++){

        const visited = Array.from({length:n+1}, ()=>0);
        let queue = [[destination,0]];
    
        while(queue.length){
            let [now, distance] = queue.shift();
            if(now === sources[i]){
                if(now!== distance && !distance){
                    distanceBox.push(-1)
                }
                else distanceBox.push(distance);
                break;
            }
            visited[now] = 1;
            tree[now].forEach(next=>{
                if(!visited[next]){
                    queue.push([next, distance+1]);
                }
            });
        }
    }

    
    return distanceBox;
}