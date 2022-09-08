function solution(priorities, location) {
    let answer =0;
    // 배열을 인덱스와 우선순위를 가진 객체로 저장
    const documents = priorities.map((priority, index)=> ({location: index, priority: priority}))
    // console.log(documents);
    let isPrint = false;
    while(!isPrint){
        //배열의 제일 앞부분의 원소를 없애고 재정렬
        const shifted = documents.shift();
        let canPrint = true;
        //만약, 현재값보다 큰 값이 배열에 있으면 맨 뒤로 옮기기
        //만약, location에 해당하는 값이 출력되면 순서 출력
        if(documents.some(doc=> shifted.priority<doc.priority)) canPrint = false;
        if(canPrint){
            answer +=1;
            if(shifted.location === location) isPrint= true;
        }else{
            documents.push(shifted);
        }
        
    }
    
    return answer;
}