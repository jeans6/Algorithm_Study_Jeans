function solution(n, weak, dist) {
    let answer = 0;
    let len = weak.length;
    
    for(let i=0; i<len-1; i++){
        let num = weak[i]+n;
        weak.push(num);
    }
    
    //멀리 갈 수 있는 친구들이 앞으로 오도록 내림차순 정렬
    dist.sort((a,b)=>b-a);
    
    //순열함수
    const getPermutations = (arr, selectNumber)=>{      
        if(selectNumber === 1) return arr.map(el=>[el]);
        const results = [];
        arr.forEach((fixed, index, origin)=>{
            const rest = [...origin.slice(0,index), ...origin.slice(index+1)];
            const permutations = getPermutations(rest, selectNumber-1);
            const attached = permutations.map(el=>[fixed,...el]);
            results.push(...attached);
        })
        return results;
    }
    
    for(let i=1; i<=dist.length; i++){
        //i명이 필요한 경우 순열
        const permutation = getPermutations(dist, i);
        
        for(const per of permutation){
            for(let j=0; j<len; j++){
                //경로 지정
                let select = weak.slice(j, len+j);
                for(const p of per){
                    const distance = select[0]+p;
                    
                    //distance가 경로보다 크면 해당 경로 삭제
                    select = select.filter(e=>e>distance);
                    
                    if(!select.length) return i;
                }
            }
        }
            
    }
    
    return -1;
}