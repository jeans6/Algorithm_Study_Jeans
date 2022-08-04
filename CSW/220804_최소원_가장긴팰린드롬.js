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
    

// slice 안 쓴 코드

    const isPalindrome2 = (str, start, end)=> {
        let length = end - start;
        for (let i = 0; i < length / 2; i++) {
            if (str[i + start] != str[end - 1 - i]) {
                return false;
            }
        }
        return true;
    }
    for (let len = s.length(); len > 1; len--) {
        for (let j = 0; j + len <= s.length(); j++) {
            if (isPalindrome2(s, j, j + len)) {
                return len;
            }
        }
    }
    return 1;


    return 1;
}