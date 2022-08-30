function solution(A, B) {
    var answer = 0;
    
    A.sort((a,b)=>b-a);
    B.sort((a,b)=>b-a);

    let Aidx =0;
    let Bidx =0;
    while(1){
        if(Aidx>=A.length || Bidx>=B.length) return answer;
        if(A[Aidx]<B[Bidx]){
            answer++;
            Bidx++;
            Aidx++;
        }else{
            Aidx++;
        }
    }
    
    return answer;
}