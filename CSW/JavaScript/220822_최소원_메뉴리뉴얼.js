function solution(orders, course) {
    var answer = [];
    
    const getCombinations = (arr, selectNum) =>{
        const results = [];
        if(selectNum === 1) return arr.map(e=>e);
        
        arr.forEach((fixed, index, origin)=>{
            const rest = origin.slice(index+1);
            const combinations = getCombinations(rest, selectNum-1);
            const attached = combinations.map(v=> fixed+ v);
            results.push(...attached);
        })
        return results;
    }
    
    for(let i=0; i<course.length; i++){
        const combi = {};
        
        orders.map(menu=>{
            //안에 있는 것들의 메뉴조합을 combi에 저장
            const result = getCombinations(menu.split('').sort(), course[i]);
            
            result.map(v => {
                if(combi[v]){
                    combi[v] += 1;
                }else{
                    combi[v] = 1;
                }
            })
        });
        //최댓값을 가지고 있는 메뉴조합을 answer에 저장
        const val = Object.values(combi);
        let max = Math.max(...val);
        if(max>1){
            for(let m in combi){
                if(combi[m] === max){
                    answer.push(m);
                }
            }
            
        }else continue;
         
    }

    console.log(answer);    
    
    return answer.sort();
}