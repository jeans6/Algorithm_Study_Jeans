function solution(s) {
    let answer = s.toLowerCase();
    let i=0;
    let len = s.length;
    
    answer = s[0].toUpperCase() + answer.substr(1);

    while(1){
        let idx = s.indexOf(" ", i);
        i = idx + 1;
        if(idx === -1 || i===len) break;
        answer = answer.substr(0,i)+s[i].toUpperCase()+answer.substr(i+1);

    }
    return answer;
}