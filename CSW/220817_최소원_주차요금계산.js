function solution(fees, records) {
    const answer = {};
    const result =[];
    const record ={};
    
    // 차번호 중복없이 저장
    const carNum = new Set();
    
    records.map((e, index)=>{
        let temp = e.split(" ");
        records[index] = temp; 
    })
    
    records.map(e => {
        let [time, num, dir] = e;
        carNum.add(num);
        if(record[num] && dir === 'OUT'){
            let temp = time.split(":").map(e=>parseInt(e));
            record[num].out = temp;
            //in과 out이 둘 다 기록되면 요금 계산
            fee(num);
        }else{
            let temp = time.split(":").map(e=>parseInt(e));
            record[num] = {in:temp, out: [-1,-1]};
        }
    })
    
    function fee(key){
        let [inTime, outTime] = [record[key].in, record[key].out];
        let min = 0;
        if(outTime[1]<inTime[1]){
            min = (60+outTime[1] - inTime[1]) + (outTime[0]-1-inTime[0])*60;
        }else{
            min = outTime[1] - inTime[1] + (outTime[0] - inTime[0])*60;
        }
        if(answer[key]){
            answer[key] += min;
        }else{
            answer[key] = min;
        }
    }
    
    // in만 들어오고 out들어오지 않은 차 요금 계산
    const carNumArr = [...carNum];
    carNumArr.map(car => {
        let [inTime, outTime] = [record[car].in, record[car].out];
        if(outTime[0]<inTime[0]){
            let min = (23-inTime[0])*60 + 59 - inTime[1];
                
            if(answer[car]){
                answer[car] += min;
            }else{
                answer[car] = min;
            }
        }else if(outTime[0]===inTime[0] && outTime[1]<inTime[1]){
            let min = (23-inTime[0])*60 + 59 - inTime[1];
                
            if(answer[car]){
                answer[car] += min;
            }else{
                answer[car] = min;
            }
        }
    });
    
    for(let car in answer){
        if(answer[car]<= fees[0]){
            answer[car] = fees[1];
        }else{
            answer[car] = fees[1] + Math.ceil((answer[car] - fees[0])/fees[2])* fees[3]; 
        }
    }
    
    // 차 번호순대로 정렬
    Object.keys(answer).sort().forEach(car =>{
        result.push(answer[car]);
    });

    return result;
}