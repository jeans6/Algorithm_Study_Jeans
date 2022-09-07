function solution(a, b, n) {
    var answer = 0;
    
    while(1){
        if(n<a) break;
        let mok = Math.floor(n/a);
        let namugi = n%a;
        answer += mok * b;
        n = namugi + mok*b;    
    }

    return answer;
}