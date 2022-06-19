function solution(participant, completion) {
    
    //각 배열 오름차순 정렬 
    const partSort = participant.sort();
    const compSort = completion.sort();
    
    //각 순서의 선수이름이 같지 않으면 출력
    //모두 같다면 마지막 남은 participant 출력
    for(let i=0; i<participant.length; i++){
        if(i===participant.length-1) return partSort[i];
        if(partSort[i]!==compSort[i]) return partSort[i];
    }
    
    
}