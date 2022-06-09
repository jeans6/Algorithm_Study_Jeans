function solution(n, computers) {
    let answer = 0;
    
    // visited arr 생성 및 초기화
    const visited = Array.from({length: n}, () => 0);
    
    // 경로 탐색이기 때문에 dfs로 풀이
    const dfs = (node) =>{
        visited[node] = 1;
        for(let i=0; i<n; i++){
            if(computers[node][i]===1 && !visited[i]){
                dfs(i);
            }
        }
    }
    
    for(let i=0; i<n; i++){
        if(!visited[i]){
            dfs(i);
            answer++;
        }
    }
    
    return answer;
}