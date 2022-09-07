function solution(operations) {
    var answer = [];   
    const seperateArray =[];
    
    for(let i=0; i<operations.length; i++){
        seperateArray.push(operations[i].split(" "));
    }
    
    for(let i=0; i<seperateArray.length; i++){
        if(seperateArray[i][0] === 'I'){
            answer.push(seperateArray[i][1]);
        }
        if(seperateArray[i][0] === 'D'){
            if(seperateArray[i][1] === '1'){
                answer.sort((a,b)=>{
                    return b-a;
                });
                answer.shift();
            }else{
                answer.sort((a,b)=>{
                    return a-b;
                });
                answer.shift();
            }
        }
    }
    if(answer.length === 0) return [0,0];
    else return [Math.max(...answer), Math.min(...answer)];
}