function solution(X, Y) {
    //100점
    var answer = '';
    const box = [];
    const Xarr = {};
    const Yarr = {};

    for(let i=0; i<X.length; i++){
        if(Xarr[X[i]]){
            Xarr[X[i]] += 1;
        }else Xarr[X[i]] = 1;
    }
    for(let i=0; i<Y.length; i++){
        if(Yarr[Y[i]]){
            Yarr[Y[i]] += 1;
        }else Yarr[Y[i]] =1;
    }

    for(let i=0; i<=9; i++){
        if(!Xarr[i]||!Yarr[i]) continue;
        let num = Math.min(Xarr[i], Yarr[i]);
        box.push([i, num]);
    }

    if(!box.length) return '-1';
    if(box.length===1 && !box[0][0]) return '0';
    
    let len = box.length;
    for(let i=len-1; i>=0; i--){
        for(let j=0; j<box[i][1]; j++){
            answer += box[i][0];
        }
    }

    return answer;
}