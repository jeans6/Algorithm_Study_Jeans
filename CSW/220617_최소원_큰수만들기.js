function solution(number, k) {
    let answer = [];
    for(let i = 0 ; i < number.length;i++){
        let value = number[i];
        // 숫자 넣으면서 앞에 들어간 숫자보다 크면 앞숫자 빼고 뒷숫자 push
        while(k > 0 && answer[answer.length-1] < value){
            answer.pop()
            k--
        }
        answer.push(value)
    }
    // 모든 숫자가 같을 경우 숫자 길이만큼 잘라주기
    answer.splice(answer.length-k,k) 
    return answer.join("")

}