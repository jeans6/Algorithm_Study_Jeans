function solution(relation) {
    var answer = 0;   
    const attr = relation[0].length;
    const indexList = Array.from(Array(attr), (x, index) => index);
    const keys =[];
    //유일성 체크 (중복체크)
    const isUnique = (combi) =>{
        // combi에 들어온 인덱스에 해당하는 속성들로 이루어진 값들이 중복이 없는지 체크
        let result = Array.from(Array(relation.length), x => '');
        for (const attrIndex of combi) {
            //forEach(callback(item, index, array))
            relation.forEach((row, rowIndex) => result[rowIndex] += row[attrIndex]);
        }
        return result.length === [...new Set(result)].length;
    }
    
    //최소성 체크 (부분집합)
    const isMin = (combi) => {
        //key에 개체들 중 combi에 포함되는 것이 있으면 최소성 검사 탈락
        for(const key of keys){
            if(key.every(v=>combi.includes(v))) return false;
        }
        return true;
    }
    
    //조합
    const getCombinations = (arr, selectNumber) =>{
        const results = [];
        if(selectNumber === 1){
            return arr.map(v => [v]);
        }
        arr.forEach((fixed, index, origin)=>{
            const rest = origin.slice(index+1);
            const combinations = getCombinations(rest, selectNumber-1);
            const attached = combinations.map(e=>[fixed,...e]);
            results.push(...attached);
        })
        
        return results;
    }
    
    for(let i=1; i<=attr; i++){
        const combi = getCombinations(indexList, i);
        for(const comb of combi){
            if(isUnique(comb) && isMin(comb)) keys.push(comb);
        }
    }
    
    return keys.length;
}