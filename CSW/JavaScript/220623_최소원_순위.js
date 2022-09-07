function solution(n, results) {
    let answer = 0;
    const graph = Array.from({ length: n + 1 }, () => Array(n + 1).fill(false));
    //이기면 1, 지면 -1
    for(const[winner, loser] of results){
        graph[winner][loser] = 1;
        graph[loser][winner] =-1;
        graph[winner][winner] = 0;
        graph[loser][loser] = 0;
    }

    for(let m=1; m<=n; m++){
        for(let i=1; i<=n; i++){
            for(let j=1; j<=n; j++){
                if(graph[i][j]===false){
                    // 초기값일 때 i가 m을 이기고 m이 j를 이기면 i는 j를 이김
                    if(graph[i][m]===1 && graph[m][j]===1){
                        graph[i][j] = 1;
                    }
                    // 초기값일 때 i가 m한테 지고 m이 j를 지면 i는 j에게 짐
                    else if(graph[i][m]===-1 && graph[m][j]===-1){
                        graph[i][j] = -1;
                    }  
                }
            }
        }
    }
    
    // 배열 속에 false가 있다면 순위를 정확하게 알 수 없음
    for(let i=1; i<=n; i++){
        let hasFalse = false;
        for(let j=1; j<=n; j++){
            if(graph[i][j] === false){
                hasFalse = true;
                break;
            }
        }
        answer = !hasFalse ? answer+1 : answer;
    }
    
    return answer;
}