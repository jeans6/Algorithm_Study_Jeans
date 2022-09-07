function solution(ingredient) {
    var answer = 0;
    
    function solution(ingredient) {
        var answer = 0;
        let now = 0;
        let len = ingredient.length;
    
        while(now<len-3){
            if(ingredient[now]===1 && ingredient[now+1]===2 && ingredient[now+2]===3 && ingredient[now+3]===1){
                answer++;
                ingredient.splice(now, 4);
                now = now-4 <0 ? 0 : now-4;
            }
            else now++;
        }
    
        return answer;
    }

    return answer;
}