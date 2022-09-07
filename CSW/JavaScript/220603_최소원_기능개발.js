function solution(progresses, speeds) {
    var answer = [];
    const release = [];
    const result = {};
    
    //배포까지 걸리는 일 수 계산
    for(let i=0; i<progresses.length; i++){
        let num = Math.ceil((100-progresses[i])/speeds[i]);
        release.push(num);
    }
    
    //뒷 순서가 더 빠르게 끝나면 앞의 순서의 기간으로 변경
    for(let i=1; i<release.length; i++){
        
        if(release[i]<release[i-1]) {
            release[i]=release[i-1];
        }  
    }
    //중복된 수 갯수 세기
    release.forEach((x) => { 
        result[x] = (result[x] || 0)+1; 
    });
    
    for(let days in result){
        answer.push(result[days]);
    }
    
    return answer;
}