function solution(n, k) {
    var answer = 0;
    
    const isPrimeNumber = (num) =>{
        if(num<=1) return false;
        for(let i=2; i<=Math.sqrt(num); i++){
            if(num%i === 0) return false;
        }
        return true;
    }
    
    let change = n.toString(k);
    const arr = change.split('0');
    
    //console.log(arr);
    for(let i=0; i<arr.length; i++){
        if(isPrimeNumber(arr[i])){
            answer++;
        }
    }
    
    return answer;
}