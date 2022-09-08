function solution(k, dungeons) {
    let answer = 0;
    let max = -1;
    let len = dungeons.length;
    let hp = k;
    const dungeon = Array.from({length:len}, (x, index)=>index);
    // 각 던전 별 순열 필요
    const getPermutations = (arr, selectNumber) =>{
        const results = [];
        if(selectNumber === 1) return arr.map(v=>[v]);
        
        arr.forEach((fixed, index, origin)=>{
            const rest = [...origin.slice(0, index), ...origin.slice(index+1)];
            const permutations = getPermutations(rest, selectNumber-1);
            const attached = permutations.map((el)=>[fixed, ...el]);
            results.push(...attached);
        })
        return results;
    }

    const explore = getPermutations(dungeon, len);
    
    for(let i=0; i<explore.length; i++){
        for(let j=0; j<len; j++){
            // hp가 최소피로도 보다 작으면 패스
            if(hp<dungeons[explore[i][j]][0]) break;
            hp -= dungeons[explore[i][j]][1];
            answer++;
        }
        // 탐험한 던전 수가 전체 던전과 같으면 바로 답 리턴
        if(answer === len) return len;
        else{
            if(answer>max) max = answer;
            hp = k;
            answer=0;
        }
    }
    
    
    return max;
}