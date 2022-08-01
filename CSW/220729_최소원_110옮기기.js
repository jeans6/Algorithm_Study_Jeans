function solution(s) {
    const results = [];
    
    for(let str of s){
        //한글자씩 모두 분리 후 스택으로 110 갯수 찾기
        const stack = [];
        const arr = str.split('');
        let count =0;
        
        for(let i=0; i<arr.length; i++){
            let third = arr[i];
            
            if(stack.length>1){
                let second = stack.pop();
                let first = stack.pop();
                
                if(first === '1' && second ==='1' && third ==='0'){
                    count++;
                    continue;
                }else{
                    stack.push(first, second, third);
                }
                
            }else{
                //최소 2개가 담기기 전까지는 110검사 못하니까 스택에 넣기
                stack.push(third);
            }
            
        }
        
        //뒤에서 부터 0이 존재하는지 체크 
        //0이 있으면 검사 중단하고 뒤에 110들을 붙여줌
        //1이 나오면 list에 옮겨담아줌
        const list =[];
        
        while(stack.length){
            let findZero = stack.pop();
            if(findZero === '0'){
                stack.push(findZero);
                break;
            }else{
                list.push(findZero);
            }
            
        }
        
        while(count){
            stack.push('1','1','0');
            count--;
        }
        
        while(stack.length){
            list.push(stack.pop());
        }
        
        results.push(list.reverse().join(''));
        
        
    }
    
    return results;
}