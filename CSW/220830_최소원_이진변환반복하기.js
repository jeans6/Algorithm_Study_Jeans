function solution(s) {
    var answer = [];
    let level = 0;
    let num = 0;
    
    while(1){
        let change = s.split(0);
        if(s === '1') break;
        level++;
        num += change.length-1;
        let len = change.join('').length;
        s = len.toString(2);        
    }
    answer.push(level, num);
    return answer;
}