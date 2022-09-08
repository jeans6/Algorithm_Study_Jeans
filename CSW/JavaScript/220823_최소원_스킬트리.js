function solution(skill, skill_trees) {
    var answer = 0;
    const master = {};
    
    
    for(let i=0; i<skill_trees.length; i++){
        let flag = 0;
        for(let z=0; z<skill.length; z++){
            master[skill[z]] = 0;
        }
        for(let j=0; j<skill_trees[i].length; j++){
            let idx = skill.indexOf(skill_trees[i][j]);

            //스킬 안에 없는 알파벳이면 넘어감
            if(idx === -1) continue;
            if(master[skill_trees[i][j]] === idx){
                if(idx !== skill.length-1) master[skill[idx+1]] = idx+1;
            }else{
                flag = 1;
                break;
            }
        }
        if(!flag){
            answer++;
        }
    }

         
    
    return answer;
}