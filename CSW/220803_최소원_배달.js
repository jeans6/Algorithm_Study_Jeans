function solution(N, road, K) {
    var answer = [1];
    const map = Array.from({length:N+1}, ()=> Array(N+1).fill(0));

    
    for(let i=1; i<=N; i++){
        road.map(e=>{
            let [a, b, distance] = e;
            if(!map[a][b]){
                map[a][b] = distance;
                map[b][a] = distance;
            }
            else {
                map[a][b] = Math.min(map[a][b], distance);
                map[b][a] = Math.min(map[b][a], distance);
            }

        })
    }
    
    const queue = [1];
    const visited = Array(N+1).fill(0);
    while(queue.length){
        let next = queue.shift();
            
        for(let j=2; j<=N; j++){
            if(!map[next][j]) continue;
            if(!visited[j] || visited[j] > visited[next] + map[next][j]){
                visited[j] = visited[next] + map[next][j];
                queue.push(j);
            }
        }

    }
  
    return visited.filter(e=> e<=K).length -1;
}