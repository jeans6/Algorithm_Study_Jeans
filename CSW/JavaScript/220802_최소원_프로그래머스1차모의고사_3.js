function solution(order) {
    //100점
    var answer = 0;
    const stack = [];
    let len = order.length;
    const visited = Array.from({length:len+1}, ()=>0);
    
    // 전보다 큰 수가 나올 때 
    const findAsc= (a, num)=>{
        for(let i=a; i<=num; i++){
            if(i!== num && visited[i]) continue;
            if(!visited[i]){
                visited[i] = 1;
                stack.push(i);
            }
            if(i===num && visited[num]){
                //stack 확인
                let next = stack.pop();
                if(next === num){
                    answer++;
                    return 1;
                    
                }else{
                    stack.push(next);
                    return 0;
                }
            }
        }
    }
    

    //전보다 작은 수가 나올 때
    const findDesc= (num)=>{

        //stack 확인
        let next = stack.pop();
        if(next === num){
            answer++;
            return 1;
        }else{
            stack.push(next);
            return 0;
        }
                    
    }

    let before = 0;
    for(let i=0; i<len; i++){
        if(before<order[i]){
            if(!findAsc(before,order[i])) return answer;
        }
        else {
            if(!findDesc(order[i])) return answer;
        }
        before = order[i];
    }

    return answer;
}