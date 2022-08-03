function solution(want, number, discount) {
    // 100점
    var answer = 0;
    let len = discount.length;
    const wantBox = {};

    for(let i=0; i<want.length; i++){
        wantBox[want[i]] = number[i];
    }

    const canDiscount = (num)=>{
        
        const temp = Object.assign({}, wantBox);

        let duration = 10+num < len ? 10+num :len;
        for(let i=num; i<duration; i++){
            if(temp[discount[i]]){
                temp[discount[i]] -= 1;
            }else continue;
        }
        
        for(let i=0; i<want.length; i++){
            if(temp[want[i]]>0) return 0;
        }

        return 1;
    }

    for(let i=0; i<len; i++){
        if(!canDiscount(i)) continue;
        answer++;
    }

    return answer;
}