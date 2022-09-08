function solution(begin, target, words) {
    let answer = 0;
    //words 안에 target 있는지 검사
    if(!words.includes(target)) return 0;
    
    let queue = [];
    let visited = [];
    
    queue.push([begin, answer]);
    
    while(queue){
        let [changeTo, cnt] = queue.shift();
        
        if(changeTo === target) return cnt;
        
        words.forEach(word => {
            let notEqual = 0;
            
            // 방문했던 단어면 pass
            if(visited.includes(word)) return;
            
            // target이랑 같지 않은 문자 갯수
            for(let i=0; i<word.length; i++){
                if(changeTo[i]!==word[i]) notEqual++;
            }
            if(notEqual === 1){
                queue.push([word, ++cnt]);
                visited.push(word);
            }
            
        })
        
        
        
    }

    


}