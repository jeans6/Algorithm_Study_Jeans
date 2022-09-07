function solution(word) {
    var answer = 0;
    
    const words = ['A','E', 'I', 'O', 'U'];
    const result = [];
    
    const getPermutations = (arr, selectNum)=>{
        const results = [];
        if(selectNum === 1) return arr.map(v=>v);
        
        arr.forEach((fixed, index, origin)=>{
            const restArr = [...origin.slice(0,index),...origin.slice(index)];
            const permutation = getPermutations(restArr, selectNum-1);
            const attached = permutation.map(e=> fixed + e);
            results.push(...attached);
        })
        return results;
    }
    
    for(let i=1; i<=words.length; i++){
        const combi = getPermutations(words, i);
        combi.map(e=>result.push(e));
    }
    
    result.sort();
    
    return result.indexOf(word)+1;
}