function solution(n, cores) {

    let len = cores.length;
    
    // 초기값 갯수만큼 빼주고 남은 갯수
    let rest = n-len;
    
    //가장 짧은 작업시간과 긴 시간
    let left = 1;
    let right = Math.max(...cores)*rest;
    
    if(n === len) return len+1;
    
    while(left<right){
        let mid = Math.floor((left+right)/2);
        let capacity = 0;
        
        for(let core of cores){
            capacity += Math.floor(mid/core);
        }
        if(capacity>=rest){
            right = mid;
        }else{
            left = mid+1;
        }
    }
    
    //right-1에서 처리된 작업수 구해서 빼주기
    for(let core of cores){
        rest -= Math.floor((right-1)/core);
    }
    
    for(let i = 0; i < len; i++) {
        if(right % cores[i] === 0) {
            rest -= 1;
            if(!rest) {
                return i + 1;
            }
        }
    }

}