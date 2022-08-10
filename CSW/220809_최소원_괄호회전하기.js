function solution(s) {
    var answer = 0;
    let len = s.length;
    const arr = s.split('');
    
    for(let i=0 ;i<len; i++){
        // i만큼 회전
        let rotate = [...arr];
        for(let j=0; j<i; j++){
            let str = rotate.shift();
            rotate.push(str);
        }
        let stack = [];
        while(1){
            // console.log(rotate, stack);
            if(stack.length>1){
                let second = stack.pop();
                let first = stack.pop();
                let rightStr = first + second;
                if(rightStr === '[]' || rightStr === '()'|| rightStr === '{}'){
                    if(!rotate.length && !stack.length) break;
                    continue;
                }else{
                    stack.push(first);
                    stack.push(second);
                    if(!rotate.length) break;
                    stack.push(rotate.shift());
                }
                
            }else{
                stack.push(rotate.shift());
            }
            
        }
        if(!stack.length) answer++;
        
        
    }
    
    
    
    
    
    return answer;
}