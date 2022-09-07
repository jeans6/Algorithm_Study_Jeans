function solution(topping) {
    let answer = 0;
    const bigbro = {};
    const smallbro = {};
    let len = topping.length;
    // 시간초과 (35점)
    for(let i=0; i<len; i++){
        if(bigbro[topping[i]]){
            bigbro[topping[i]] += 1;
        }
        else bigbro[topping[i]] = 1;
    }
    
    for(let i=0; i<len; i++){
        if(Object.keys(bigbro).length < Object.keys(smallbro).length) break;
        let num = topping.shift();
        bigbro[num] -= 1;
        if(!bigbro[num]){
            delete bigbro[num];
        }
        if(smallbro[num]){
            smallbro[num] += 1;
        }
        else smallbro[num] = 1;

        if(Object.keys(bigbro).length === Object.keys(smallbro).length){
            answer++;
        }
    }
    

    return answer;
}