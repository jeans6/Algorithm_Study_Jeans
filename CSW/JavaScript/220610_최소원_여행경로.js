function solution(tickets) {
    let answer = [];
    const result = [];
    const len = tickets.length;

    // 어짜피 출발역은 ICN이니 같은 역에서 출발할 때 도착역들을 오름차순으로 정렬해둔 후 시작
    tickets.sort();
    console.log(tickets);
    
    const visited = Array.from({length:len},()=>0)

    const dfs = (from,level) =>{
        result.push(from);
        
        if(level === len){
            answer = result;
            return true;
        }
        
        for(let i=0; i<len; i++){
            if(!visited[i] && tickets[i][0]===from){
                visited[i] = 1;

                // 제대로 dfs 탐색하고 있다면 true
                // 잘못된 탐색을 했다면 방문 취소 후 계속 탐색하도록 
                // 계속 1,2 실패가 떠서 ++level에서 level+1로 바꾸니까 통과했다
                // ++level은 level에 1을 더한 다음 할당하는 거니까 바로 적용되어야되는거 아닌감..? 뭐가 문제인지 아는 사람 알려줘
                if(dfs(tickets[i][1], level+1)) return true;
                visited[i] = 0;
                result.pop();
            }
        }
        
        // 전체역을 탐색하지 못하는 경로로 들어간 경우 result에서 삭제하고 돌아가도록 해야 한다.
        return false;
        
    };
    
    dfs("ICN", 0);
    console.log(visited);

    return answer;
}