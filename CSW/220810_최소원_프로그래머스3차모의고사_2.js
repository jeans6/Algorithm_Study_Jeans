function solution(ingredient) {
    var answer = 0;
    
    // 시간초과(82.4점)
    // let arr = ingredient.join('');
   
    // while(1){
    //     let idx = arr.indexOf('1231');
    //     if(idx === -1) break;
    //     arr = arr.substring(0,idx) + arr.substring(idx+4);
    //     answer++;
    // }

    // 시간초과 (52.9점)
    // let stack = [];
    // while(1){
    //     if(stack.length>3){
    //         let fourth = stack.pop();
    //         let third = stack.pop();
    //         let second = stack.pop();
    //         let first = stack.pop();
    //         if(first === 1 && second === 2&& third === 3 && fourth === 1){
    //             answer++;
    //             if(!ingredient.length) break;
    //         }else{
    //             stack.push(first, second, third, fourth);
    //             if(!ingredient.length) break;
    //             stack.push(ingredient.shift());
    //         }
    //     }else{
    //         if(!ingredient.length) break;
    //         stack.push(ingredient.shift());
    //     }
    // }


    return answer;
}