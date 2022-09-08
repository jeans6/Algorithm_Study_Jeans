function solution(number) {
    var answer = 0;

    const getCombinations = (arr, selectNumber) =>{
        const results = [];
        if(selectNumber === 1){
            return arr.map(v=>[v]);
        }
        arr.forEach((fixed, index, origin)=>{
            const rest = origin.slice(index+1);
            const combinations = getCombinations(rest, selectNumber-1);
            const attached = combinations.map(e=>[fixed, ...e]);
            results.push(...attached);
        })
        return results;
    }

    const combi = getCombinations(number, 3);
    
    combi.map(e=>{
        let [one, two, three] = e;
        let sum = one + two + three;
        if(sum === 0) answer++;
    })

    return answer;
}