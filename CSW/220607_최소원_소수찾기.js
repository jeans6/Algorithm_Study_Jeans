function solution(numbers) {
    let result = [];
    let answer=0;
    const num = [...numbers];
    
    //순열
    const getPermutations = (arr, selectNum)=>{
        let results =[];
        //하나 선택할 경우
        if(selectNum === 1) return arr.map((v)=>[v]);
        
        arr.forEach((fixed, index,origin)=>{
            //fixed 제외한 순열
            const rest = [...origin.slice(0,index),...origin.slice(index+1)]
            const permutations = getPermutations(rest, selectNum-1);
            const attached = permutations.map((el)=>[fixed+el]);
            results.push(...attached);
        });
        
        return results;
    }
    
    //소수 판별
    const isPrime = (val)=>{
        
        if(val<2) return false;
         // 2는 짝수 중 유일한 소수이다
        if( val % 2 === 0) { 
            return val === 2 ? true : false;
         }

        const sqrt = parseInt(Math.sqrt(val));

        for( let i = 3; i <= sqrt; i += 2) {

            if(val % i === 0) {
              return false;
            }

        }

      return true;
    }
    
    for(let i=1; i<=num.length; i++){
        getPermutations(num, i).forEach((el)=>{
            isPrime(parseInt(el)) ? result.push(parseInt(el)) : result
        });
    }
    //중복제거
    result = [...new Set(result)];

    return result.length;
}