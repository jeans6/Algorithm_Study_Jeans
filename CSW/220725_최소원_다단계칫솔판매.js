function solution(enroll, referral, seller, amount) {
    var answer = [];
    //추천해준 사람으로 받는 이익
    const benefit = {}; // name, amount
    //추천해준 사람
    const refer = {}; // name, referral
    
    enroll.map((e,index)=>{
        refer[e] = referral[index];
    })
    
    
    // 추천인으로부터의 이익 초기화
    enroll.map(e=>{
        if(!benefit[e]){
            benefit[e] = 0;
        }
    })
    
    for(let i=0; i<seller.length; i++){
        let sellAmount = amount[i]*100;
        let temp = seller[i];
        benefit[temp] += sellAmount;
        //추천인이 "-"일 때까지 계속 계산
        while(1){
            let referman = refer[temp];
            let tenPercent = Math.floor(sellAmount*0.1);
            if(!tenPercent) break;
            benefit[temp] -=  tenPercent;
            if(referman==="-") break;
            benefit[referman] += tenPercent;
            temp = referman;
            sellAmount = tenPercent;
        } 
    }
    
    //result
    enroll.map((e)=>{
        answer.push(benefit[e]);
    })
    
    
    
    return answer;
}