function solution(numbers) {
    const answer =[];
    numbers.map(v => {
        let str = '0'+v.toString(2);
        //짝수일 경우 마지막 0->1 로
        if(str[str.length-1] === '0') {
            str = str.substring(0, str.length-1) + '1';
        } else {
            //홀수일 경우 뒤에서 01이 나오는걸 찾아서 10으로 바꿔주기
            const idx = str.lastIndexOf('01');
            str = str.substring(0,idx) + '10' + str.substring(idx+2, str.length);
        }
        
        answer.push(parseInt(str, 2));
    })
    return answer;
}