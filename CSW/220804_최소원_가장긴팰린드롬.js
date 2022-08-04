function solution(s)
{
    
    const isPalindrome = (original)=>{
        let len = original.length;
        for(let k=0; k<len/2; k++){
                if(original[k]!==original[len-k-1]) {
                    return false;
                };
            }
        return true;
    }
    
    for(let j=s.length; j>1; j--){
        for(let i=0; i<=s.length-j; i++){

            if(isPalindrome(s.slice(i, i+j))){
                return j
            }

        }
    }
    

//효율성 통과 x    
//     for(let j=0; j<=s.length; j++){
//         for(let i=j; i<=s.length; i++){
                 
//             const original = arr.slice(j,i);
//             const rev = arr.slice(j,i).reverse();

//             if(JSON.stringify(original) !== JSON.stringify(rev)) continue;

//             max = Math.max(max, original.length);
//         }
//     }


    return 1;
}