function solution(n, lost, reserve) {
    //lost는 0, reserve는 2, 나머지는 1로 배열만들기
    const state = [];
    let cnt = 0;
    //모든 학생들은 1로 초기화
    for(let i=0; i<n; i++){
        state[i] =1;
    }
    
    //lost와 reserve 값 가져올 때 -1해주기
    //reserve 학생들은 2
    for(let i=0; i< reserve.length; i++){
        state[reserve[i]-1] = 2;
    }
    //lost 학생들은 reserve학생일 때는 1, 아니면 0
    for(let i=0; i< lost.length; i++){
        if(state[lost[i]-1]===2) state[lost[i]-1] = 1;
        else state[lost[i]-1] = 0;
    }

    console.log(state);
    for(let i=0; i<n; i++){
        // 0인 학생이라면? idx-1과 idx+1이 2인지 탐색
        if(state[i]===0){
            if(state[i-1]>=0 && state[i-1]===2){
                state[i-1] = 1;
                state[i]=1;
                continue;
            }
            else if(state[i+1]<n && state[i+1] ===2){
                state[i+1] = 1;
                state[i] =1;
            }
            
        }
    }
    
    
    
    
    //숫자세기 
    for(let i=0; i<n; i++){
        if(state[i]===0) continue;
        cnt ++;
    }
    
    return cnt;
}