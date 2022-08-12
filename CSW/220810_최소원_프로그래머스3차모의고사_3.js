function solution(distance, scope, times) {

    //scope 정렬 오름차순
    scope.map(e=>{
        e.sort((a,b)=>a-b);
    })
    scope.map((e,index)=> e.push(index));
    scope.sort((a,b)=>a[0]-b[0]);
    // console.log(scope);

    for(let t=0; t<scope.length; t++){
        let [start, end] = [scope[t][0], scope[t][1]];
        let sum = times[scope[t][2]][0] + times[scope[t][2]][1];
        for(let i=start; i<=end; i++){
            let timing = i%sum;
            if(!timing || timing > times[scope[t][2]][0]){
                continue;
            }else{
                return i;
            }
        }
    }


    return distance;
}