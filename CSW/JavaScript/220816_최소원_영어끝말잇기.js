function solution(n, words) {
    var answer = [0,0];
    
    const word = {};
    let end = '';
    for(let i=0; i<words.length; i++){

        if(i>0 && end !== words[i][0]){
            let level = Math.floor(i/n + 1);
            let person = i%n+1;
            if(!level) level = n;
            return [person, level];
        }
        if(word[words[i]]){
            let level = Math.floor(i/n + 1);
            let person = i%n+1;
            if(!level) level = n;
            return [person, level];
        }else{
            word[words[i]] = 1;
        }
        end = words[i][words[i].length-1];
        
    }
    

    return answer;
}