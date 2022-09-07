function solution(n, times) {
    let answer = 0;

    // 오름차순 정렬
    times.sort((a,b)=>a-b);
     
    //가장 많이 걸리는 시간 경우
    let right = times[times.length-1] * n;
    let left = 0;
    
    //이분탐색으로 중간 값만큼 시간이 걸린다고 가정했을 때
    //승객 수가 n이랑 가까워지는 경우를 구함
    while(left<=right){
        let mid = Math.floor((left+right)/2);
        let max = 0;
        
        for(let v of times){
            max += Math.floor(mid/v);
        }
        
        if(max>=n){
            answer = mid;
            right = mid - 1;
        }else{
            left = mid +1;
        }
        
    }
    
    return answer;
}