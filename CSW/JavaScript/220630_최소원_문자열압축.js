function solution(s) {
    let answer = s.length;
    
    // i글자씩 자르며 완전탐색
    for(let i=1; i<=parseInt(s.length/2);i++){
        let tempStr = s.substr(0,i);
        let str = "";
        let cnt = 1;
        
        for(let idx = i; idx<=s.length; idx += i){
            let nextStr = s.substr(idx,i);
            
            if(tempStr === nextStr){
                cnt +=1;
            }else{
                if(cnt === 1) str = str + tempStr;
                else str = str + cnt + tempStr;
                
                cnt = 1;
                tempStr = nextStr;
            }
        }
        //마지막에 포함 못시킨 문자열 추가
        if(cnt === 1) str = str + tempStr;
        else str = str + cnt + tempStr;

        answer = Math.min(answer, str.length);
        
    }
    
    return answer;
}