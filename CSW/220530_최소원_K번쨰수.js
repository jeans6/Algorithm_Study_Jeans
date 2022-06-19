function solution(array, commands) {
    let result = [];
    let temp = [];
    
    //slice함수로 배열 자른 후 sort로 오름차수 정렬
    for(let i=0; i< commands.length ; i++){
        temp = array.slice(commands[i][0]-1, commands[i][1]).sort((a,b)=>a-b);
        result.push(temp[commands[i][2]-1]);
        console.log(temp);
    }
    
    
    return result;
}