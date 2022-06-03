function solution(numbers) {
    var answer = '';
    
    //유니코드 기준 정렬 후 뒤집기
    numbers= numbers.sort().reverse();
    
    //앞부터 숫자를 연결했을 때 비교해서 큰 경우 리턴
    numbers = numbers.sort((a,b)=>{
        const A = parseInt(a.toString() + b.toString());
        const B = parseInt(b.toString() + a.toString());
        return B - A;
    });

    //정렬한 숫자 연결
    answer = numbers.join('');
    if(answer[0] === '0') return '0'
    
    return answer;
}