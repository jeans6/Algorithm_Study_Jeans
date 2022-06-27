function solution(people, limit) {
    let answer = 0;
    let weight = 0;
    const temp = [];

    //계속 안돼서 삽질하고 다른 풀이법 찾아봤는데 
    //sort함수에 조건을 지정해주지 않으면 아스키코드순대로 정렬되기 때문에 숫자의 경우 꼭 조건문을 써주어야한다!!
    people.sort((a,b)=>a-b);
    
    while(people.length){
        if(temp.length){
            let front = temp.shift();
            let back = people.pop();
            weight = front+ back;
            if(weight>limit){
                answer++;
                temp.push(front);
                weight = 0;
            }else{
                answer++;
                weight = 0;
            }
        }else{
            if(people.length === 1) return answer+1;
            let front = people.shift();
            let back = people.pop();
            weight = front+ back;
            if(weight>limit){
                answer++;
                temp.push(front);
                weight = 0;
            }else{
                answer++;
                weight = 0;
            }
        }
    }
    
    return temp.length === 0 ? answer : answer+1;
}

// 더 나은 풀이법
function solution(people, limit){
	let answer = 0;
    people.sort((a,b)=>a-b);
    let l = 0;
    let r = people.length-1;
    
    while(l<r){
        let weight = people[l] + people[r];
        if(weight>limit){
             r--;
         }else{
             r--;
             l++;
         }
        answer++;
     }
    if(l === r) answer++;
    
    
    return answer;
}