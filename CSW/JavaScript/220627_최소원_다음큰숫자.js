function solution(n) {
    var answer = 0;
    //자바스크립트에서 n진수 변환 : toString(n)
    //n진수에서 십진수 변환 : parseInt(num);
    const temp = n.toString(2).split('');
    let isOne = temp.filter(v=> v==='1').length;
    let next = n+1;

    while(1){
        let compare = next.toString(2).split('').filter(v=> v==='1').length;        
        if(compare == isOne){
            return next;
        }else next = next+1;
    }
}