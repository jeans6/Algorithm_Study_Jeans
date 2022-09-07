function solution(n,a,b)
{
    var answer = 1;
    
    // 수를 하나씩 빼면 2로 나눈 몫이 같을 때 대결
    let aa = a-1;
    let bb = b-1;
    
    while(1){
        if(Math.floor(aa/2) === Math.floor(bb/2)){
            break;
        }
        aa = Math.floor(aa/2);
        bb = Math.floor(bb/2);
        answer++;
    }

    return answer;
}